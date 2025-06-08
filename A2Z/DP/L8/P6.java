import java.util.Arrays;

class P6 {
    public boolean isPalindrome(int i,int j,String s){
        
        while(i<j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;

    }
    public int Memoization(int i,String s,int dp[]){
        if(i == s.length())return 0;
        if(dp[i] != -1)return dp[i];
        int ans = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(i,j,s)){
                int curr_ans = 1 + Memoization(j+1, s,dp);
                ans = Math.min(curr_ans, ans);
            }
        }
        return dp[i]=ans;
    }
    public int minCut(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return Memoization(0,s,dp)-1;
    }
}