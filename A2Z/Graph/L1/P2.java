import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {
    class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }
}
    public static void main(String[] args) {
       
    }
}
