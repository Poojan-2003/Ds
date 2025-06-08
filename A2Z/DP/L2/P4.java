package L2;

import java.util.Arrays;

public class P4 {

    public static int Recursion(int arr[],int i){
        if(i>=arr.length){
            return 0;
        }

        return Math.max(arr[i]+Recursion(arr, i+2),Recursion(arr, i+1));
    }
    public static int Memoization(int arr[],int i,int dp[]){
        if(i>=arr.length){
            return 0;
        }

        if(dp[i] != -1)return dp[i];

        return dp[i] = Math.max(arr[i]+Memoization(arr, i+2,dp),Memoization(arr, i+1,dp));
    }

    public static int Tabulation(int nums[]){
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            int pick = nums[i];

            if(i>1){
                pick+=dp[i-2];
            }

            int nonpick = dp[i-1];

            dp[i] = Math.max(pick, nonpick);
        }
        return dp[nums.length-1];
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 3, 5, 8, 1, 9};
        int dp[] = new int[9];
        Arrays.fill(dp, -1);
        System.out.println(Recursion(arr,0));
        System.out.println(Memoization(arr,0,dp));
    }
}
