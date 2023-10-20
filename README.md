# [Binary Search](https://github.com/Jianuo-Always-Coding/laicode_solution_java/tree/main/BinarySearch/)

This part contains the problems which can use binary search to solve to optimize time complexity from O(n) to O(logn).

Binary search always solve problems with 2 conditions such sorted array and find a arget number.

# [Linked List](https://github.com/Jianuo-Always-Coding/laicode_solution_java/tree/main/LinkedList/)

This part contains the problems which is related to a new class List Node. This part can do **mergeSortLinkedList** and **CheckIfLinkedListIsPalindrome** to review.

```java
class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

```

The key point of this part including

- find mid node
- reverse a Linked List
- combine two Linked List

# [Recursion](https://github.com/Jianuo-Always-Coding/laicode_solution_java/tree/main/Recursion/)

This part contains some problems which can be solved with recursion, including some sort algorithms, such as **Selection Sort, Merge Sort** and **Quick Sort**. Notably, tail recursion can be converted into iteration.

# [Deque, Stack and Queue](https://github.com/Jianuo-Always-Coding/laicode_solution_java/tree/main/DequeAndQueue/)

Complete the solution with Stack, Queue and Deque, including some Object-oriented Design for Stack, Queue and Deque.

# [Binary Tree and Binary Search Tree](https://github.com/Jianuo-Always-Coding/laicode_solution_java/tree/main/BinaryTreeAndBinarySearchTree/)

- A **binary tree** is a tree which at most has 2 branches
- A **balanced binary tree** is a tree that the difference height of left tree and right tree is less or equal to 1.
- A **complete binary tree** is a tree that only the last layer has null value, and no number after null.

- A **binary Search tree** is a tree like binary search. All the nodes in the left tree are smaller than root, and all the nodes in the right tree are greater than root.

# [Graph Search I BFS](https://github.com/Jianuo-Always-Coding/laicode_solution_java/tree/main/GraphSearchIBFS/)

For Binary tree's level order traversal.

```java
while (!queue.isEmpty()) {
    List<Integer> layer = new ArrayList<>();
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        layer.add(cur.key);
        if (cur.left != null) {
            queue.offer(cur.left);
        }
        if (cur.right != null) {
            queue.offer(cur.right);
        }
    }
    result.add(layer);
}
```

# [Heap & TopK](https://github.com/Jianuo-Always-Coding/laicode_solution_java/tree/main/BinaryHeap&TopK/)

1. Create a PriorityQueue -- Max heap

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(k, Collections.reverseOrder()));
```

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if(o1.equals(o2)) {
          return 0;
        }
        return o1 > o2 ? -1 : 1;
      }
    });
```

2. percolateUp & percolateDown

   n is the size of the minHeap / maxHeap
   - percolateUp & percolateDown TC : O(logn)
   - Heapify TC : O(n)
3. Review this section, do **Top k Frequent Words** and **Kth Closest Point To <0,0,0>**.
4. useful API

```java
List<Integer> n = Arrays.asList(0, 0, 0);
```

# [Graph Search II : DFS](https://github.com/Jianuo-Always-Coding/laicode_solution_java/tree/main/Graph%20Search%20II%20%3A%20DFS)


Array = [1,2,3,4]

**SubSet** : [1,3,2] 
- is not continous and does not maintain relative order of elements (子集，不保持相对顺序也不连续)

**SubSequence** ： [1,2,4] 
- is not continous but maintains relative order of elements（子序列，不连续但是保持相对顺序）

**SubArray** ： [1,2],[1,2,3] 
- is continous and maintains relative order of elements（子数组，保持相对顺序并连续）

#

Array = [1,2,3,4]

**Combination** : {{}, {1}, {2}, ...., {3,4}, ...}
- Can not add , no order
- (组合， 可以不加， 没有顺序)

**Permutation** : {{1,2,3,4}, {1,2,4,3}, ...}
- All the elements must in, must add all, have order. 
- (排列 ， 不能不加， 有顺序)