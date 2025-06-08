public class P2 {
    public static int Recursion(int i,int j,int dp[][]){
        if(i==0 || j==0 ){
            return 1;
        }
        if(dp[i][j] != -1)return dp[i][j];
        return dp[i][j] = Recursion(i-1, j,dp)+Recursion(i,j-1,dp)+1;
    }
    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int dp[][] = new int[m][n];
        Recursion(m-1,n-1,dp);
    }
}
