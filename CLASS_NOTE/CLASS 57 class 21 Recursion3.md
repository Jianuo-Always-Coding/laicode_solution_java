# CLASS 57 Recursion 3

## 人字形问题

> - 从左孩子和右孩子分别要结果
> - 在当前层通过左右孩子得到的结果进行操作，并将结果返回上一层

### [Determine whether a binary tree is balanced](https://app.laicode.io/app/problem/46)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/is_balanced.java)
> - get Height: if not balanced return -1
> - TC : O(n)

### [Max Sum from a leaf node to another leaf](https://app.laicode.io/app/problem/138)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/Max_Sum_From_Leaf_To_Leaf.java)
> - Only it has left and right child, can update globalMax. (不然可能是一条直上直下路径)

### [Max Sum from any node to any （可人可直）](https://app.laicode.io/app/problem/139)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/Max_sum_from_any_node_to_any_node.java)
> - If the value pass by left or right child is negative, then drop.

## 直上直下路径

<mark>当从root 到 leaf的时候需要特别注意，因为一旦root == null return0的时候，左边为null = 0，右边为负数，则就会舍弃右边，但此时左边是0，不满足从root 到 leaf的条件</mark>

### [Max Sum from leaf to root](https://app.laicode.io/app/problem/639?plan=3)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/Max_Path_Sum_From_Leaf_To_Root.java)
> - <mark>注意左或右为空的时候直接返回另一半</mark>
> - 类似 DFS，在 leaf node 更新 globalMax。
> - 去左，去右，遍历整棵树。

### [Determine whether exist a straight path（any node to any node）which sum equals to target](https://app.laicode.io/app/problem/141)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/Straight_path_sum_equals_to_target.java)
> - 类似 prefixSum 的思想，
> - 注意要在 recursion function 的最后，判断加进去的 sum 是否需要 move（保证去右的时候，没有左的 sum）

### [Max Sum from any node to any（直上直下）](https://app.laicode.io/app/problem/140?plan=3)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/Max_Sum_from_any_node_to_any_straight.java)

## Tree serialization problem -> Reshape

### [Given a binary tree, fatten it to a linked list](https://app.laicode.io/app/problem/523?plan=3)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/flatten_tree_to_linkedList.java)
> - pre-order only have right child
> - Use a prev[0] to record prev;
> - root.left = null;

### What if post-order?

## Tree De-serialization problem

> Can not Restructure a tree:
>
> - Only have a in-order
> - Pre-order and post-order
> - Pre-order and post-order and level-order

> Can Restructure a tree:
>
> - in-order with one of any ways

Use a map to store the value position of in-order

### [pre-order and in-order](https://app.laicode.io/app/problem/213?plan=3)
> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/Reconstruct_Binary_Tree_With_Preorder_And_Inorder.java)


### [post-order for Binary Search Tree](https://app.laicode.io/app/problem/211)
> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/postOrder_for_Binary_Search_Tree.java)

### [level-order and in-order](https://app.laicode.io/app/problem/215)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_57/Level_order_and_in_Order_for_Tree.java)

> - 每次要把 level-order 的第 0 号元素删除 leverOrder.remove(0);
> - 通过 root.value 在 in-order 中的 index，判断是在左子树还是在右子树
> - 新建两个 list，按顺序存储左和右的值
