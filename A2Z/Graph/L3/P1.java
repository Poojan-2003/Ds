package Graph.L3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1 {
    public int[] dijkstra(ArrayList<ArrayList<int[]>>adj,int V, int source){
        PriorityQueue<int[]>pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,source});
        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        while(!pq.isEmpty()){
            int []currNode = pq.poll();
            int d = currNode[0];
            int u = currNode[1];

            if (d > dist[u]) continue;

            for(int[] edge : adj.get(u)){
                int v = edge[0];
                int weight = edge[1];

                int newDistance = dist[u] + weight;
                if(newDistance < dist[v]){
                    dist[v] = newDistance;
                    pq.add(new int[]{newDistance, v});
                }
            }
        }
        return dist;
    }
}
