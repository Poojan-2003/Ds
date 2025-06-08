package L8;

import java.util.Arrays;

public class P2 {
    static int matrixMultiplication(int[] arr, int N) {
        int[][] dp = new int[N][N];

        // Initialize the dp array with -1
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // Initialize the diagonal with 0
        for (int i = 1; i < N; i++) {
            dp[i][i] = 0;
        }

        // Fill in the dp array using bottom-up approach
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int minOperations = Integer.MAX_VALUE;

                // Partitioning loop to find the optimal split point
                for (int k = i; k <= j - 1; k++) {
                    int operations = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    minOperations = Math.min(minOperations, operations);
                }

                dp[i][j] = minOperations;
            }
        }

        // The result is stored in dp[1][N-1]
        return dp[1][N - 1];
    }
}
