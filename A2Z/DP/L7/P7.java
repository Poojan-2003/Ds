import java.util.Arrays;

// Logic : We will keep count array which will store count of maximum lis uptil index i

public class P7 {
    class Solution {
    public int findNumberOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int cnt[] = new int[nums.length];
        int n = nums.length;
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int len = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    cnt[i] = cnt[j];
                }else if(nums[i]>nums[j] && dp[j]+1 == dp[i]){
                    cnt[i]+=cnt[j];
                }
            }

            maxi = Math.max(maxi,dp[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxi)ans+=cnt[i];
        }
        return ans;

    }
}
}
