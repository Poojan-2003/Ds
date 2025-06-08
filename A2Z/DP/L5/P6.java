import java.util.Arrays;

public class P6 {
    class Solution {
    public int Memoize(int i,int j,String a, String b,int dp[][]){
        if(i==a.length())return b.substring(j,b.length()).length();
        if(j==b.length())return a.substring(i,a.length()).length();
        if(i==a.length() && j==b.length())return 0;
        
        if(dp[i][j] != -1)return dp[i][j];
        int ans = 0;
        if(a.charAt(i) != b.charAt(j)){
            ans = 1+(Math.min(Memoize(i+1,j,a,b,dp),Memoize(i,j+1,a,b,dp)));
        }else{
            ans = Memoize(i+1,j+1,a,b,dp);
        }

        return dp[i][j] = ans;
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return Memoize(0,0,word1,word2,dp);
    }
}
}
