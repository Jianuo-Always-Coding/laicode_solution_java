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
        Map<GraphNode, GraphNode> map = new HashMap<>();
        List<GraphNode> result = new ArrayList<>();
        for (GraphNode node : graph) {
            GraphNode cur = helper(node, map);
            result.add(cur);
        }
        return result;
    }

    private GraphNode helper(GraphNode node, Map<GraphNode, GraphNode> map) {
        // base case
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        GraphNode newNode = new GraphNode(node.key);
        map.put(node, newNode);
        for (GraphNode nei : node.neighbors) {
            newNode.neighbors.add(helper(nei, map));
        }
        return newNode;
    }
}

// TC : O(E + V)
// SC : O(V)