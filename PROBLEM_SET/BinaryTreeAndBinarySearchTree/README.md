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

## In-order Traversal Of Binary Tree (iterative)

Poll a node from the stack. And put its right child into the stack. As long as you put a TreeNode into the stack, you should also put its all leftNode into the stack.

有左往左走，没左弹栈打印往右走。
while(cur != null || stack.isEmpty())

## <mark style="background-color : Yellow"> Post-order Traversal Of Binary Tree (iterative) </mark>

We use prev and cur to record the path state. First, put root into the stack. When start node or from root to child, peek the first node, if have left add left. No left node ,if have right node add right. (You can consider, every time when peekFirst, it is a new tree.) if no left and no right, add result and return.

If from left, add right.

If from right, add right.

Importantly, we need to move prev to cur every time.