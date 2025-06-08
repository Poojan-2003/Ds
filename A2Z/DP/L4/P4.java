import java.util.*;
class P4{
        public static int Memoize(int i,int nums[], int tar,int curr_sum,int dp[][]){
        if (i == nums.length || curr_sum>tar) {
            return (curr_sum == tar) ? 1 : 0; // If sum matches target, count it
        }

        if(dp[i][curr_sum] != -1)return dp[i][curr_sum];
        // Include the current element in subset sum
        int include = 0;
        if(curr_sum<=tar){

            include = Memoize(i + 1, nums, tar, curr_sum + nums[i],dp);
        }

        // Exclude the current element from subset sum
        int exclude = Memoize(i + 1, nums, tar, curr_sum,dp);
        dp[i][curr_sum] = (include+exclude)%1000000007;
        return dp[i][curr_sum]; // Sum up both choices
    }    
    public static int findWays(int num[], int tar) {
        int dp[][] = new int[num.length][tar+1];
        for(int []a : dp){
            Arrays.fill(a,-1);
        }
        return Memoize(0,num,tar,0,dp);
    }
}