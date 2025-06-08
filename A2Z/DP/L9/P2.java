import java.util.Arrays;

public class P2 {
    class Solution {

        public int Memoize(int i, int j, int matrix[][], int[][] dp) {
            if (i >= matrix.length || j >= matrix[0].length) {
                return 0;
            }

            if (matrix[i][j] == 0)
                return dp[i][j] = 0;
            if (dp[i][j] != -1)
                return dp[i][j];

            int left = Memoize(i, j + 1, matrix, dp);
            int right = Memoize(i + 1, j, matrix, dp);
            int diag = Memoize(i + 1, j + 1, matrix, dp);

            return dp[i][j] = 1 + Math.min(left, Math.min(right, diag));
        }

        public int countSquares(int[][] matrix) {
            int ans = 0;
            int dp[][] = new int[matrix.length][matrix[0].length];

            for (int arr[] : dp) {
                Arrays.fill(arr, -1);
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] != 0) {
                        ans += Memoize(i, j, matrix, dp);
                    }
                }
            }

            return ans;
        }
    }


        public int countSquares(int[][] matrix) {
            int dp[][] = new int[matrix.length][matrix[0].length];
    
            int ans = 0;
            for(int i=0;i<dp.length;i++){
                ans+=dp[i][0] = matrix[i][0] ;
            }
    
            for(int i=1;i<dp[0].length;i++){
                ans+= dp[0][i] = matrix[0][i] ;
            }
            for(int i=1;i<dp.length;i++){
                for(int j=1;j<dp[0].length;j++){
                    if(matrix[i][j] == 0){
                       dp[i][j] = 0;
                    }else{
                        ans+=dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    }
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return ans;
        }
    
}
