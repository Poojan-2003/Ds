public class P9 {
        public static int Memoize(int i,int j,String w1, String w2,int dp[][]){
            if(i<0)return j+1;
            if(j<0)return i+1;
            if(dp[i][j] != -1)return dp[i][j];
            if(w1.charAt(i) == w2.charAt(j))return dp[i][j]=Memoize(i-1,j-1,w1,w2,dp);
            
                return dp[i][j]=Math.min(
                    1+Memoize(i,j-1,w1,w2,dp),Math.min(
                    1+Memoize(i-1,j,w1,w2,dp),
                    1+Memoize(i-1,j-1,w1,w2,dp))
                );
            
        }
        public int minDistance(String word1, String word2) {
            int dp[][] = new int[word1.length()+1][word2.length()+1];
            // for(int arr[]:dp){
            //     Arrays.fill(arr,-1);
            // }
            // return Memoize(word1.length()-1,word2.length()-1,word1,word2,dp);
    
            for(int i=0;i<=word1.length();i++){
                dp[i][0] = i;
            }
    
            for(int i=0;i<=word2.length();i++){
                dp[0][i] = i;
            }
            for(int i=1;i<=word1.length();i++){
                for(int j=1;j<=word2.length();j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
            
                    else{ dp[i][j]=Math.min(
                        1+dp[i][j-1],Math.min(1+dp[i-1][j],1+dp[i-1][j-1])
                    );
                    }
                }
            }
            System.out.println(Arrays.deepToString(dp));
            return dp[word1.length()][word2.length()];
        }   
}
