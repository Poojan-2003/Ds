import java.util.Arrays;

public class P6 {
    public int Memoize(int index,int canBuy,int prices[],int fee,int dp[][]){
        if(index == prices.length){
            return 0;
        }
        if(dp[index][canBuy] != -1)return dp[index][canBuy];
        int profit = 0;
        if(canBuy == 0){
            profit = Math.max(-prices[index]+Memoize(index+1,1,prices,fee,dp),Memoize(index+1,0,prices,fee,dp));
        }else{
            profit = Math.max(prices[index]-fee+Memoize(index+1,0,prices,fee,dp),Memoize(index+1,1,prices,fee,dp));
        }

        return dp[index][canBuy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int []n:dp){
           Arrays.fill(n,-1); 
        }
        return Memoize(0,0,prices,fee,dp);
    }

}
