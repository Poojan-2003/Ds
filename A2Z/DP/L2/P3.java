package L2;

public class P3 {
        public static int minimizeCost(int n, int k, int []height){
            int dp[] = new int[n];
            dp[0] = 0;
    
            for(int i=1;i<n;i++){
                int minStep = Integer.MAX_VALUE;
    
                for(int j=1;j<=k;j++){
                    if(i-j>=0){
                        int jump = dp[i-j]+ Math.abs(height[i]-height[i-j]);
                        minStep = Math.min(jump, minStep);
                    }
                }
                dp[i] = minStep;
            }
            return dp[n-1];
        }
    public static void main(String[] args) {
        
    }
}
