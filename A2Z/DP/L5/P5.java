import java.util.Arrays;

public class P5 {
    class Solution {
    public int minInsertions(String s) {
        // if(s.length()==1)return 1;
        StringBuilder b  = new StringBuilder();        
        b.append(s);
        b.reverse();
        // System.out.println(b);

        int dp[]= new int[s.length()+1];
        int prev[]= new int[s.length()+1];
        for(int i=0;i<dp.length;i++){
            prev[i] = 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp.length;j++){
                if(s.charAt(i-1) == b.toString().charAt(j-1)){
                    dp[j] = 1+prev[j-1];
                }else{
                    dp[j] = Math.max(dp[j-1],prev[j]);
                }
            }
        System.out.println(Arrays.toString(dp));
            prev = dp.clone();
        }
        return s.length()-dp[dp.length-1];

    }
    
}

}
