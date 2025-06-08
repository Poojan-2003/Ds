import java.util.Stack;

public class P5 {
        public boolean parseBoolExpr(String expression) {
            Stack<Character>st = new Stack<>();
    
            for(int i=0;i<expression.length();i++){
                char currChar = expression.charAt(i);
                if(expression.charAt(i) == ',' || expression.charAt(i) == '(')continue;
                if (
                    currChar == 't' ||
                    currChar == 'f' ||
                    currChar == '!' ||
                    currChar == '&' ||
                    currChar == '|'
                ) {
                    st.push(currChar);
                }else if(currChar == ')'){
                    boolean hastrue = false;
                    boolean hasfalse = false;
    
                    while(st.peek() != '&' && st.peek() != '|' && st.peek() != '!'){
                        char topValue = st.pop();
                        if(topValue == 'f')hasfalse = true;
                        if(topValue == 't')hastrue = true;
                    }
                     char op = st.pop();
                    if (op == '!') {
                        st.push(hastrue ? 'f' : 't');
                    } else if (op == '&') {
                        st.push(hasfalse ? 'f' : 't');
                    } else {
                        st.push(hastrue ? 't' : 'f');
                    }
                }
            }
    
            return st.peek() == 't';
        }
    }