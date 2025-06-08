import java.util.*;

public class P5 {
    public static int Memoization(int i, int arr[], int target, int curr_sum, int dp[][]) {
        if (i == arr.length || curr_sum > target) {
            return (curr_sum == target) ? 1 : 0;
        }
        if (dp[i][curr_sum] != -1)
            return dp[i][curr_sum];

        int include = 0;
        if (curr_sum <= target) {
            include = Memoization(i + 1, arr, target, curr_sum + arr[i], dp);
        }
        int exclude = Memoization(i + 1, arr, target, curr_sum, dp);

        return dp[i][curr_sum] = (include + exclude) % 1000000007;
    }
    // public static int Memoize(int i,int nums[], int tar,int curr_sum,int dp[][]){
    // if (i == nums.length || curr_sum>tar) {
    // return (curr_sum == tar) ? 1 : 0; // If sum matches target, count it
    // }

    // if(dp[i][curr_sum] != -1)return dp[i][curr_sum];
    // // Include the current element in subset sum
    // int include = 0;
    // if(curr_sum<=tar){

    // include = Memoize(i + 1, nums, tar, curr_sum + nums[i],dp);
    // }

    // // Exclude the current element from subset sum
    // int exclude = Memoize(i + 1, nums, tar, curr_sum,dp);
    // dp[i][curr_sum] = (include+exclude)%1000000007;
    // return dp[i][curr_sum]; // Sum up both choices
    // }

    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int val : arr) {
            totalSum += val;
        }
        int tar = (totalSum - d) / 2;
        // System.out.println(target);
        if (tar <= 0)
            return 0;
        if ((totalSum - d) % 2 == 1)
            return 0;
        int dp[][] = new int[arr.length][tar + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return Memoization(0, arr, tar, 0, dp);
    }

}
