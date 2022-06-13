package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
Find Nth nearest neighbours in a graph.
- Do a BFS with tracking the depth. When it’s N - return whatever is in the queue. Haven’t checked, but should in that direction.
 */
public class NthNeighbors {

    public static boolean findNearest(Map<String, List<String>> graph, int n, String root){
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            String node = queue.poll();
            for(String neighbour : graph.get(node)){
                queue.add(neighbour);
            }
            if (node.equals("N")) count++;
            if (count == n) return true;
        }
        return false;
    }
}
