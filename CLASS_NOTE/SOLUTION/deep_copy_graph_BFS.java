/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // corner case
    if (graph == null) {
      return null;
    }
    List<GraphNode> result = new ArrayList<>();
    Map<GraphNode, GraphNode> map = new HashMap<>();

    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        GraphNode newNode = new GraphNode(node.key);
        map.put(node, newNode);
      } 
      GraphNode cur = map.get(node);
      result.add(cur);

      for (GraphNode nei : node.neighbors) {
        if (!map.containsKey(nei)) {
          GraphNode newNode = new GraphNode(nei.key);
          map.put(nei, newNode);
        }
        cur.neighbors.add(map.get(nei));
      }
    }
    return result;
  }
}
// BFS - ITERATIVE
// V (NUMBER OF NODE) E (NUMBER OF EDGE)
// TC : O(V + E)
// SC : O(1)