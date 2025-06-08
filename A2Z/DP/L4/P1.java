package L4;

import java.util.Arrays;

public class P1 {
    public static boolean Memoize(int i,int arr[],int k,int sum,int dp[][]){
        if(sum == k)return true;
        if(i>=arr.length || sum>k)return false;
        if (dp[i][sum] != -1) return dp[i][sum] == 1?true:false;
        boolean include = false;
        if (sum + arr[i] <= k) { 
            include = Memoize(i + 1, arr, k, sum + arr[i], dp);
        }        
        boolean exclude = Memoize(i+1,arr,k,sum,dp);
         dp[i][sum] = include || exclude ? 1 : 0;
        return  include||exclude;
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for(int ar[]:dp){
            Arrays.fill(ar,-1);
        }
        return Memoize(0,arr,k,0,dp);
    }
}
