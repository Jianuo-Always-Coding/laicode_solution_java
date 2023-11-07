# DEEP COPY

> - [Deep Copy Linked List With Random Pointer](#Deep-Copy-Linked-List-With-Random-Pointer)
> - [Deep Copy Undirected Graph](#Deep-Copy-Undirected-Graph)
> - [Find a node whose value is cloest to the target value](#Cloest-Value)
> - [Largest Number Smaller In Binary Search Tree](#Largest-Number-Smaller-Than-Target)
> - [2 SUM return boolean unsorted](#2SUM-Boolean)
> - [2 SUM return pair unsorted](#2Sum-Pair)
> - [2 SUM return pair of values unsorted](#2Sum-Pair-Values)

<mark> When create a new Node, you must put that in a map pair.</mark>

<a id="Deep-Copy-Linked-List-With-Random-Pointer"></a>

## [Deep Copy Linked List With Random Pointer](https://app.laicode.io/app/problem/131)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/deep_copy_randomList.java)

<a id="Deep-Copy-Undirected-Graph"></a>

## [Deep Copy Undirected Graph](https://app.laicode.io/app/problem/132)

> - [SOLUTION BFS ITERATION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/deep_copy_graph_BFS.java)
> - All the node in the map is just a pair, not totally equal. We should update the neighbor in the loop of each graphnode.

> - [SOLUTION DFS RECURSION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/deep_copy_graph_DFS.java)
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

<a id="Cloest-Value"></a>

## [Find a node whose value is cloest to the target value](https://app.laicode.io/app/problem/135)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/Closest_Number_In_Binary_Search_Tree.java)
> - First, judge whether the root can be put into the result. In this case root maybe a valued result ,so we initialized reuslt = root.key.
> - If equal we return, else we update result and go down to find.

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

<a id="Largest-Number-Smaller-Than-Target"></a>

## [Largest Number Smaller In Binary Search Tree](https://app.laicode.io/app/problem/136)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/Largest_Number_Smaller_In_Binary_Search_Tree.java)
> - As long as we can find a node less than target, we need to update.

```java
while (cur != null) {
    if (cur.key < target) {
        result = cur.key;
        cur = cur.right;
    } else {
        cur = cur.left;
    }
}
```

# 2, 3, 4 SUM

<mark>NOT ONLY THE SOLUTION, CLARIFY IS MORE IMPORTANT.</mark>

> - **Order : ascending or decending or unsorted**
> - **Return : True or False / Pair**
> - Duplated or not
> - 1 TB?
> - Overflow? value is large
> - **Optimise time or space**

When do 3 SUN or 4 SUM, we need to notice **The index range**.

## 2 SUM

### SORTED - Use two pinters

1. ### 2 SUM return boolean

2. ### 2 SUM return pair
   We can use 2 pointers.
   > - Duplicated:
   >   > - Find the blocks of the same number
   >   > - Compare the sum with target.
   >   > - Then add to reuslt.

<a id="2SUM-Boolean"></a>

### UNSORTED

1. ### [2 SUM return boolean](https://app.laicode.io/app/problem/180)
   > - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/2_sum_boolean.java)
   > - Use a **Set** to record the numbers which has already seen.
   > - Find whether the rest value is in set, then add to set. **(Search first then add to set)**

<a id="2Sum-Pair"></a>

2. ### [2 SUM return pair of index](https://app.laicode.io/app/problem/181)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/2_sum_pair.java)
> - Use a **Map** to record the pair of (value, list of index).
>   > - Find whether the rest value is in map, then add to map. **(Search first then add to set)**

<a id="2Sum-Pair-Values"></a>

3. ### [2 SUM return pair of values](https://app.laicode.io/app/problem/182)

> - Method 1: Use Arrays.sort(array);

> - Method 2: Use a map to record (value, count).
> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/2_sum_pair_of_values.java)
> - count just be 0/1. If count = 1, means this number is added to result. If count = 0, means this number is not added to result.
> - <mark>When added to result, both value and pairVal should update to 1.</mark>

## [3 SUM return pair of values](https://app.laicode.io/app/problem/186)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/3SUM.java)
> - Use a for loop, transfer 3 SUM to 2 SUM
> - Sorted first. (Arrays.sort(array);)
> - <mark>The for loop index i is the smallest index int the result, so the range of the rest 2 index should from i+1 to the end.</mark>
> - Jumped duplicated number.

## [4 SUM return boolean](https://app.laicode.io/app/problem/188)

> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_55/4_sum.java)
> - Two for loop and two pointers.
