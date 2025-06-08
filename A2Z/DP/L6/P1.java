package L6;

//Logic : Maintain minValue at which we can buy stock and update at every iteration and calculate maxprofit which is nums[i]-minStockPrice and update total profit at every iteration

public class P1 {
        public int maxProfit(int[] prices) {
            int minStockPrice = prices[0];
            int maxProfit = Integer.MIN_VALUE;
    
            for(int i=1;i<prices.length;i++){
                maxProfit = Math.max(prices[i]-minStockPrice,maxProfit);
                minStockPrice = Math.min(minStockPrice, prices[i]);
            }
    
            return maxProfit < 0 ? 0 : maxProfit;
        }
}
