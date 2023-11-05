package Review and Strengthen;

/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */

/*
 * Determine if an undirected graph is bipartite. 
 * 
 * A bipartite graph is one in which the nodes can be divided into two groups 
 * 
 * such that no nodes have direct edges to other nodes in the same group.
 * 
 */

public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    // corner case
    if (graph.size() <= 2) {
      return true;
    }
    Queue<GraphNode> q = new ArrayDeque<>();
    Map<GraphNode, Integer> seen = new HashMap<>();


    for (GraphNode node : graph) {
      if (!seen.containsKey(node)) {
        seen.put(node, 0);
        q.offer(node);
      } else {
        continue;
      }

      while (!q.isEmpty()) {
        GraphNode e = q.poll();
        int label = seen.get(e);
        int neiLabel = (label == 0 ? 1 : 0);

        for (GraphNode nei : e.neighbors) {
          if (!seen.containsKey(nei)) {
            seen.put(nei, neiLabel);
            q.offer(nei);
          } else if (seen.get(nei) != neiLabel) {
            return false;
          }
        }
      }
    }
    return true;
  }
}

// TC : O(V + E)
// SC : O(V)