package L5;

import java.util.Arrays;

public class P10 {

    public boolean Memoize(int i, int j, String s, String p, int dp[][]) {
        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0)
            return false;
        if (j < 0 && i >= 0) {
            for (int ii = 0; ii <= i; ii++) {
                if (s.charAt(ii) != '*')
                    return false;
            }
            return true;
        }
        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if (s.charAt(i) == p.charAt(j) || s.charAt(i) == '?') {
            dp[i][j] = Memoize(i - 1, j - 1, s, p, dp) ? 1 : 0;
        } else if (s.charAt(i) == '*') {
            dp[i][j] = (Memoize(i - 1, j, s, p, dp) || Memoize(i, j - 1, s, p, dp)) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j] == 1;
    }

    public boolean isMatch(String s, String p) {
        int dp[][] = new int[p.length()][s.length()];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        // return Memoize(p.length() - 1, s.length() - 1, p, s, dp);

        for(int i=0;i<p.length();i++){
            for(int j=0;j<s.length();j++){
                if (s.charAt(i) == p.charAt(j) || s.charAt(i) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (s.charAt(i) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] ? 1 :0;
                } else {
                    dp[i][j] = 0;
                }
        
                return dp[i][j] == 1;
            }
        }
    }
}
