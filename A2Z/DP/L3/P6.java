import java.util.Arrays;
import java.util.List;

public class P6 {

    public static int Memoization(int i,List<List<Integer>> triangle){
        if(i==0){
            System.out.println(triangle);
            System.out.println(triangle.get(0).get(0)+Math.min(triangle.get(1).get(0),triangle.get(1).get(1)));
            return triangle.get(0).get(0)+Math.min(triangle.get(1).get(0),triangle.get(1).get(1));
            // return;
        }
        //i==3
        for(int t=0;t<triangle.get(i).size();t++){
            triangle.get(i).set(t,triangle.get(i).get(t)+Math.min(triangle.get(i+1).get(t),triangle.get(i+1).get(t+1)));
        }
        return Memoization(i-1,triangle);
        
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1)return triangle.get(0).get(0);
        int dp[][] = new int[triangle.size()][triangle.get(0).size()];
        return Memoization(triangle.size()-2,triangle);
        //  return 0;
    }

     public int Tabulation(List<List<Integer>> triangle) {
        if(triangle.size()==1)return triangle.get(0).get(0);
        int dp[][] =  new int[triangle.size()][triangle.size()];

        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[i][j] = triangle.get(i).get(j)+Math.min(
                    dp[i+1][j],
                    dp[i+1][j+1]
                );
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }
}

