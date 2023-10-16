# Binary Tree & Binary Search Tree

## Delete In Binary Search Tree

Here we use the smallest larger node is first candidate after deletion.

**prev** is the parent of the smallest larger node. **cur** is the smallest larger node. Becasue cur may have right child, so we need to give the right child to prev.

```java
prev.left = cur.right;
cur.left = root.left;
cur.right = root.right;
return cur;
```

## Pre-order Traversal Of Binary Tree (iterative)

Poll from a stack, and offer right child into the stack,then offer left child into the stack. (弹栈打印，右进去左进去)

## Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

Poll a node from the stack. And put its right child into the stack. As long as you put a TreeNode into the stack, you should also put its all leftNode into the stack.

先把 root 和他所有的左子节点放进去，每次弹栈一个，并加入 result，如果这个节点有右子树，把右子树和所有右子树的所有左节点也加进去。
