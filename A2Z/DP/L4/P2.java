package L4;

import java.util.Arrays;

public class P2 {
    public static boolean Memoize(int i, int nums[], int target, int curr_sum, int dp[][]) {
        if (curr_sum == target / 2)
            return true;
        if (i >= nums.length || curr_sum > target / 2)
            return false;
        boolean include = false;
        if (dp[i][curr_sum] != -1)
            return dp[i][curr_sum] == 0 ? false : true;
        if (curr_sum + nums[i] <= target / 2) {
            include = Memoize(i + 1, nums, target, curr_sum + nums[i], dp);
        }
        boolean exclude = Memoize(i + 1, nums, target, curr_sum, dp);
        dp[i][curr_sum] = include || exclude == true ? 1 : 0;
        return include || exclude;
    }

    public boolean canPartition(int[] nums) {
        int ans = 0;
        for (int a : nums) {
            ans += a;
        }
        int dp[][] = new int[nums.length][ans / 2];
        if (ans % 2 != 0)
            return false;
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return Memoize(0, nums, ans, 0, dp);
    }
}
