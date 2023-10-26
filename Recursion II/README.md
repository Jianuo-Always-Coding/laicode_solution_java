# Recursion II
##  N Queens
Time Complexity analyst:

A recursion tree should have n branches, and each of them have n branches. So totally, the tree should have n^n nodes. But we can use valid function to cut some branches, like the same column, so at the end the time complexity should be O(n! * n), because for the valid function has O(n) time complexity. 

## Store Number Of Nodes In Left Subtree
<mark>Do not pass! REWRITE!</mark> 

## Reverse Binary Tree Upside Down
<mark>Do not pass! REWRITE!</mark> 

Once cut the connection of child node, we will lose the control of the upper node, because each node only have 2 fields. When we chage we must lose something inportant. Hence, we need to do reverse first before we change the connection.

- Recursion
```java
TreeNode newNode = reverse(root.left);
root.left.left = root;
root.left.right = root.right;
root.left = null;
root.right = null;
```

- Iteration
```java
TreeNode prev = null;
TreeNode prevRight = null;
while (root != null) {
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = prev;
    root.right = prevRight;
    prev = root;
    prevRight = right;
    root = left;
}
return prev;
```

## Bipartite
<mark>Do not pass! REWRITE!</mark> 

> If all GraphNode's neighbor nodes are suit the requirement, then we said the graph is bipartite.

> If we can't find this node in map, we put it into queue, and find its neighbor nodes. If we can find, just judge.