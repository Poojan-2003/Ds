package L2;

// https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/

import java.util.Arrays;

public class P2 {
    
    public static int FrogJump(int n, int heights[]){
        int dp[] = new int[n+1];
        dp[1] = Math.abs(heights[0]-heights[1]);
        dp[2] = Math.abs(heights[0]-heights[2]);
        for(int i=3;i<n;i++){
            dp[i] = Math.min(dp[i-1]+Math.abs(heights[i]-heights[i-1]), dp[i-2]+Math.abs(heights[i]-heights[i-2]));
        }
        return dp[n-1];

    }

    public static int FrogJumpMemo(int ind,int height[],int dp[]){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne= FrogJumpMemo(ind-1, height,dp)+ Math.abs(height[ind]-height[ind-1]);
        if(ind>1)
            jumpTwo = FrogJumpMemo(ind-2, height,dp)+ Math.abs(height[ind]-height[ind-2]);
        
        return dp[ind]=Math.min(jumpOne, jumpTwo);
    }
    public static void main(String[] args) {
        int heights[] = {10,20,30,10};
        int dp[] = new int[heights.length+1];
        Arrays.fill(dp, -1);
        System.out.println(FrogJump(heights.length, heights));
        System.out.println(FrogJumpMemo(heights.length-1, heights,dp));
    }
}
