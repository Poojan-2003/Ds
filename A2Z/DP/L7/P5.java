import java.util.Arrays;

public class P5 {
    class Solution {

        public boolean isSame(String big, String small) {
            if (big.length() != small.length() + 1)
                return false;

            int i = 0;
            int j = 0;

            while (i < big.length()) {
                if (j < small.length() && big.charAt(i) == small.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }

            return i == big.length() && j == small.length() ? true : false;
        }

        public int longestStrChain(String[] words) {
            Arrays.sort(words, (a, b) -> a.length() - b.length());
            System.out.println(Arrays.toString(words));
            int dp[] = new int[words.length];
            Arrays.fill(dp, 1);
            int maxi = 1;
            // dp[0] = 1;
            for (int i = 0; i < words.length; i++) {
                String next = words[i];
                for (int j = 0; j < i; j++) {
                    String prev = words[j];
                    if (isSame(next, prev) && 1 + dp[j] > dp[i]) {
                        System.out.println(next + " " + prev);
                        dp[i] = dp[j] + 1;
                    }
                }
                maxi = Math.max(maxi, dp[i]);
            }
            return maxi;
        }
    }
}
