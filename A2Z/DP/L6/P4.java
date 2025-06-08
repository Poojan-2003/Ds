import java.util.Arrays;

public class P4 {
    class Solution {
    public int Memoize(int index, int canBuy, int prices[], int dp[][][], int maxTransaction) {
        if (maxTransaction == 0)
            return 0;
        if (index == prices.length)
            return 0;

        if (dp[index][canBuy][maxTransaction] != -1)
            return dp[index][canBuy][maxTransaction];

        int profit = 0;
        if (canBuy == 0) {
            profit = Math.max(-prices[index] + Memoize(index + 1, 1, prices, dp, maxTransaction),
                    Memoize(index + 1, 0, prices, dp, maxTransaction));
        } else {
            profit = Math.max(prices[index] + Memoize(index + 1, 0, prices, dp, maxTransaction - 1),
                    Memoize(index + 1, 1, prices, dp, maxTransaction));
        }

        return dp[index][canBuy][maxTransaction] = profit;
    }

    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length+1][2][k + 1];
        for (int arr[][] : dp) {
            for (int ar[] : arr) {
                Arrays.fill(ar, 0);
            }
        }

        // return Memoize(0, 0, prices, dp, k);
        // int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int p = 1; p <= k; p++) {
                    int profit = 0;
                    if (j == 0) {
                        dp[i][j][p] = Math.max(-prices[i] + dp[i + 1][1][p],
                                dp[i + 1][0][p]);
                    } else {
                        dp[i][j][p] = Math.max(prices[i] + dp[i + 1][0][p - 1],
                                dp[i + 1][1][p]);
                    }

                      
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0][k];
    }
}
}
