import java.util.Arrays;

public class P5 {
    public int Memoize(int index, int canBuy, int prices[], int dp[][][],int cd) {
        if (index == prices.length)
            return 0;
        if (cd == 1)
            return Memoize(index + 1, canBuy, prices, dp, 0);
        if (dp[index][canBuy][cd] != -1)
            return dp[index][canBuy][cd];

        int profit = 0;
        if (canBuy == 0) {
            profit = Math.max(-prices[index] + Memoize(index + 1, 1, prices, dp, 0),
                    Memoize(index + 1, 0, prices, dp, 0));
        } else {
            profit = Math.max(prices[index] + Memoize(index + 1, 0, prices, dp, 1),
                    Memoize(index + 1, 1, prices, dp, 0));
        }

        return dp[index][canBuy][cd] = profit;
    }

    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length + 1][2][2];
        for (int arrr[][] : dp) {
            for (int arr[] : arrr) {
                    Arrays.fill(arr, -1);
            }
        }

        return Memoize(0, 0, prices, dp,  0);
    }

}
