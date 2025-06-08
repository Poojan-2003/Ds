import java.util.*;
class P1{
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int nextSmaller[] = new int[heights.length];
            int prevSmaller[] = new int[heights.length];
            Stack<Integer> st = new Stack<>();
            int n = heights.length;
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                    st.pop();
                }
    
                if (st.isEmpty()) {
                    nextSmaller[i] = n;
                } else {
                    nextSmaller[i] = st.peek();
                }
    
                st.push(i);
            }
    
            while (!st.isEmpty())
                st.pop();
    
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                    st.pop();
                }
    
                if (st.isEmpty()) {
                    prevSmaller[i] = -1;
                } else {
                    prevSmaller[i] = st.peek();
                }
    
                st.push(i);
            }
            System.out.println(Arrays.toString(prevSmaller));
            System.out.println(Arrays.toString(nextSmaller));
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (nextSmaller[i] - prevSmaller[i] - 1) * heights[i]);
    
            }
            return ans;
        }
    
        public int maximalRectangle(char[][] matrix) {
            int arr[] = new int[matrix[0].length];
            int ans = 0;
            for (int i = 0; i < matrix.length; i++) {
                // System.out.println(largestRectangleArea(arr));
                // System.out.println(Arrays.toString(arr));
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 1) {
                        // System.out.println(arr[j]+" ");
                        // System.out.println(" ");
    
                    }
                    int a = matrix[i][j] == '1' ? 1 : 0;
                    arr[j] = a == 0 ? 0 : a + arr[j];
                    // System.out.println(arr[j]+" ");
                }
    
                // System.out.println(largestRectangleArea(arr));
                System.out.println(Arrays.toString(arr));
                ans = Math.max(ans, largestRectangleArea(arr));
            }
            return ans;
        }
    }
}