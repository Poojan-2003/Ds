import java.util.ArrayList;
import java.util.Arrays;

class P4{
        public int solve(int i,int j,ArrayList<Integer>arr,int dp[][]){
            if(i>j)return 0;
            if(dp[i][j] != -1)return dp[i][j];
    
            int mini = Integer.MIN_VALUE;
            for(int k=i;k<=j;k++){
                int ans = arr.get(i-1)*arr.get(k)*arr.get(j+1)+(solve(i,k-1,arr,dp)+solve(k+1,j,arr,dp));
                mini = Math.max(ans,mini);
            }
            return dp[i][j] = mini;
        }
        public int maxCoins(int[] nums) {
            ArrayList<Integer>arr = new ArrayList<>();
            arr.add(1);
            for(int a:nums){
                arr.add(a);
            }
            arr.add(1);
            int dp[][] = new int[arr.size()][arr.size()];
            for(int ar[]:dp){
                Arrays.fill(ar,-1);
            }
            return solve(1,nums.length,arr,dp);
        }
}