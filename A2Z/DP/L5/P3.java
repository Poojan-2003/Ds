public class P3 {

    public static int lcs(String str1, String str2){
        int dp[] = new int[str2.length()+1];
        // for(int i=0;i<dp.length;i++){
        //     dp[i][0] = 0;
        // }
        // System.out.println(Arrays.deepToString(dp));
        for(int i=1;i<str2.length();i++){
            dp[i] = 0;
        }
        int ans = 0;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<str2.length();j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    // System.out.println("here");
                    dp[j] = 1+dp[j-1];
                    ans = Math.max(ans,dp[j]);
                }else{
                    dp[j] = 0;
                    // dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        String ans = "";
        while(i>=0 && j>=0){
            if(str1.charAt(ans)))
        }
        // System.out.println(Arrays.deepToString(dp));
        return ans;
    }
}

