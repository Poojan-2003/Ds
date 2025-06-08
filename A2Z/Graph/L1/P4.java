import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(N) + O(2E), Where N = Nodes, 2E is for total degrees as we traverse all adjacent nodes.

// Space Complexity: O(3N) ~ O(N), Space for queue data structure visited array and an adjacency list

public class P4 {
    public ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer>bfs = new ArrayList<>();
        Queue<Integer>q =new LinkedList<>();
        boolean vis[] = new boolean[V];
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            
            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
        
    }

}
