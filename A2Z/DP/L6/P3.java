import java.util.Arrays;

class P3{
    public int Memoize(int index,int canBuy,int prices[],int dp[][][],int maxTransaction){
        if(maxTransaction == 0)return 0;
        if(index == prices.length)return 0;


        if(dp[index][canBuy][maxTransaction] != -1)return dp[index][canBuy][maxTransaction];

        int profit = 0;
        if(canBuy == 0){
            profit = Math.max(-prices[index] + Memoize(index+1,1,prices,dp,maxTransaction),Memoize(index+1,0,prices,dp,maxTransaction));
        }else{
            profit = Math.max(prices[index]+Memoize(index+1,0,prices,dp,maxTransaction-1),Memoize(index+1,1,prices,dp,maxTransaction));
        }

        return dp[index][canBuy][maxTransaction] = profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];
        for(int arr[][]:dp){
            for(int ar[]:arr){
                Arrays.fill(ar,-1);
            }
        }

        return Memoize(0,0,prices,dp,2);
    }
}