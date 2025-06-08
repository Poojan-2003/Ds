import java.util.ArrayList;
import java.util.Stack;

public class P5 {
    public void dfsTraversal(int n,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>dfs,boolean[]vis){
        vis[n] = true;
        dfs.add(n);
            for(Integer it : adj.get(n)){
                if(!vis[it]){
                    dfsTraversal(it,adj,dfs,vis);
                }
            }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer>ans = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        vis[0] = true;
        
        dfsTraversal(0,adj,ans,vis);
        
        return ans;
    }
}

//Time Complexity : O(N)+O(2*E)
// Space Complexity: O(N)+O(N)+O(N) : Recursion Stack Space + ArrayList Space + Boolean array
