package L6;

import java.util.Arrays;

public class P2 {
    public int maxProfit(int[] prices) {
        int buy=0;
       int sell=0;
       int profit =0;
       
       for(int i =0 ; i< prices.length-1; i++) {
           buy=prices[i];
           sell=prices[i+1];
           int x =sell-buy;
           if(x<0) {
               profit += 0;
           }else {
               profit += x;
           }
       }
       
       
       return profit;
   }

    public int Memoize(int index,int canBuy,int prices[],int dp[][]){
        if(index == prices.length)return 0;

        if(dp[index][canBuy] != -1)return dp[index][canBuy];

        int profit = 0;
        if(canBuy == 0){
            profit = Math.max(-prices[index] + Memoize(index+1,1,prices,dp),Memoize(index+1,0,prices,dp));
        }else{
            profit = Math.max(prices[index]+Memoize(index+1,0,prices,dp),Memoize(index+1,1,prices,dp));
        }

        return dp[index][canBuy] = profit;
    }
    public int maxProfit1(int[] prices) {
        // We will memoize : dp[i][1] => Max profit upto index i and having stock in bag 
        // We will memoize : dp[i][0] => Max profit upto index i and having capactiy to pick in bag 
        int dp[][] = new int[prices.length][2];

        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return Memoize(0,0,prices,dp);
    }
}
