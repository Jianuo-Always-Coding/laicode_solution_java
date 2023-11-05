# DEEP COPY

## [Deep Copy Linked List With Random Pointer](https://app.laicode.io/app/problem/131)

- [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION/deep_copy_randomList.java)
- Use a map to record the nodes which have already created.
- Must put (head, newHead) into map.s

## [Deep Copy Undirected Graph](https://app.laicode.io/app/problem/132)
<mark> When create a new Node, you must put that in a map pair.</mark>

> - [SOLUTION BFS ITERATION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION/deep_copy_graph_BFS.java)
> - All the node in the map is just a pair, not totally equal. We should update the neighbor in the loop of each graphnode.

> - [SOLUTION DFS RECURSION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION/deep_copy_graph_DFS.java)
> - The input of the recursion function is (node_need_copied, map), and the output of the recursion function is the copied node.
> - As well as the node is put into map, the node is totally copied, the same with it's neighbors.

