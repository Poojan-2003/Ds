import java.util.List;

public class P5 {
    public static int Memoization(int i,List<List<Integer>> triangle){
        if(i==0){
            return Math.min(triangle.get(1).get(0),triangle.get(1).get(1));
        }
        //i==3
        for(int t=0;t<triangle.get(i).size();t++){
            triangle.get(i).set(t,Math.min(triangle.get(i+1).get(t),triangle.get(i+1).get(t+1)));
        }
        Memoization(i-1,triangle);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.get(0).size()];
        return Memoization(triangle.size()-2,triangle);
    }
}
