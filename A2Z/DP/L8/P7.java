import java.util.Arrays;

class P7 {

    public static int Memoization(int i,int arr[],int dp[],int k){
        if(i==dp.length)return 0;

        if(dp[i] != -1)return dp[i];

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for(int j=i;j<Math.min(i+k,arr.length);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = (len*maxi)+Memoization(j+1,arr,dp,k);
            ans = Math.max(ans,sum);
        }

        return dp[i] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return Memoization(0,arr,dp,k);
    }
    public int Tabulation(int dp[],int arr[],int k){
        for(int i=arr.length-1;i>=0;i--){
            int ans = Integer.MIN_VALUE;
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            for(int j=i;j<Math.min(i+k,arr.length);j++){
                len++;
                maxi = Math.max(maxi,arr[j]);
                int sum = len*maxi + dp[j+1];
                ans = Math.max(ans,sum);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}