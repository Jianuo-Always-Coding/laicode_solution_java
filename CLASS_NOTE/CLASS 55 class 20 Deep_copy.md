# DEEP COPY

<mark> When create a new Node, you must put that in a map pair.</mark>
## [Deep Copy Linked List With Random Pointer](https://app.laicode.io/app/problem/131)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION/deep_copy_randomList.java)


## [Deep Copy Undirected Graph](https://app.laicode.io/app/problem/132)



> - [SOLUTION BFS ITERATION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION/deep_copy_graph_BFS.java)
> - All the node in the map is just a pair, not totally equal. We should update the neighbor in the loop of each graphnode.

> - [SOLUTION DFS RECURSION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION/deep_copy_graph_DFS.java)
> - The input of the recursion function is (node_need_copied, map), and the output of the recursion function is the copied node.
> - As well as the node is put into map, the node is totally copied, the same with it's neighbors.
> - <mark>The recursion function is return a totally copied node.</mark>
```java
// DFS solution -- recursion function
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
```
# Binary Search Tree
## [Find a node whose value is cloest to the target value](https://app.laicode.io/app/problem/135)
> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION/Closest_Number_In_Binary_Search_Tree.java)
```java
while (cur != null) {
    if (cur.key == target) {
        return cur.key;
    } else {
        if (Math.abs(cur.key - target) < Math.abs(result - target)) {
            result = cur.key;
        }

        if (cur.key > target) {
            cur = cur.left;
        } else {
            cur = cur.right;
        }
    }
}
```