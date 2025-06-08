// package L8;

import java.util.ArrayList;
import java.util.Arrays;

public class P3 {
    class Solution {

    public int solve(int i,int j,ArrayList<Integer>arr,int dp[][]){
        if(i>j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int mini = (arr.get(j+1)-arr.get(i-1))+solve(i,k-1,arr,dp)+solve(k+1,j,arr,dp);
            ans = Math.min(ans,mini);
        }

        return dp[i][j] = ans;
    }
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer>arr = new ArrayList<>();

        arr.add(0);
        Arrays.sort(cuts);
        for(int i=0;i<cuts.length;i++){
            arr.add(cuts[i]);
        }
        arr.add(n);
        int dp[][] = new int[arr.size()][arr.size()];
        for(int []ar:dp){
            Arrays.fill(ar,-1);
        }
        return solve(1,arr.size()-2,arr,dp);
    }
}
}
