package L2;
import java.util.Arrays;

public class P1 {

    public static int Recursion(int n){
        if(n==1 || n==2)return  n;
        return Recursion(n-1)+Recursion(n-2);
    }

    public static int Memoization(int n,int dp[]){
        if(n==1 || n==2)return n;
        
        if(dp[n] != -1)return dp[n];

        return dp[n] = Memoization(n-1,dp)+Memoization(n-2,dp);
    }

    public static int Tabulation(int n){
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }


    public static void main(String[] args) {
        int dp[] = new int[6];
        Arrays.fill(dp, -1);
        System.out.println(Recursion(4));
        System.out.println(Memoization(4,dp));
        System.out.println(Tabulation(4));
    }
}
