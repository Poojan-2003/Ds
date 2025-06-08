package L8;

import java.util.Arrays;

public class P1 {
    public static int solve(int i,int j,int arr[],int dp[][]){
        if(i>=j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int ans = (arr[i-1]*arr[k]*arr[j])+solve(i,k,arr,dp)+solve(k+1,j,arr,dp);
            mini = Math.min(mini,ans);
        }
        return dp[i][j]=mini;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int dp[][] = new int[arr.length][arr.length];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }
        return solve(1,arr.length-1,arr,dp);
    }

}
