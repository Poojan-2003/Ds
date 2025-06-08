public class P4{
    public int Tabulation(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            if(i==0){
                dp[0][0] = grid[0][0];
            }else{
                dp[i][0] = dp[i-1][0]+grid[i][0];
            }
        }

        for(int i=1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i]; 
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j]= Math.min(grid[i][j]+dp[i][j-1],grid[i][j]+dp[i-1][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public int Memoization(int [][]grid,int dp[][],int m,int n){
        if(m==0 && n==0){
            return dp[m][n] = grid[0][0];
        }
        //If we are out of bound then we return max value so we optimally discard this path
        if(m==0 || n==0)return (int) Math.pow(10, 9);

        if(dp[m][n] != -1)return dp[m][n];

        int top = grid[m][n]+Memoization(grid, dp, m-1, n);
        int left = grid[m][n]+Memoization(grid, dp, m, n-1);

        return dp[m][n] = Math.min(top, left);
    }
}