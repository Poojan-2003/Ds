package L1;

public class P1{

    public static int simpleRecursion(int n){
        if(n==0 || n==1){
            return n;
        }
        return simpleRecursion(n-1)+simpleRecursion(n-2);
    }
    public static int Memoization(int n, int dp[]){
        if(n==0 || n==1){
            return n;
        }

        if(dp[n] != -1)return dp[n];
        return dp[n] = Memoization(n-1,dp)+Memoization(n-2,dp);
    }

    public static int Tabulation(int n){
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        // for(int i=2;i<n;i++){
        //     dp[i] = dp[i-1]+dp[i-2];
        // }
        // return dp[n-1];

        // Using 2 Pointer
        int prev = dp[1];
        int prev2 = dp[0];
        int curr = 0;
        for(int i=2;i<n;i++){
            curr = prev+prev2;
            prev = prev2;
            prev2 = curr;
        }
        return curr;
    }
    public static void main(String[]args){
        System.out.println(simpleRecursion(7));        
        System.out.println(Tabulation(7));        
    }
}