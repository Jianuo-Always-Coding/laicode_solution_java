# K-way merge

## [Problem 1 Merge k sorted Arrays for array](https://app.laicode.io/app/problem/133)

## [Problem 1 Merge k sorted Arrays for list](https://app.laicode.io/app/problem/134)

- [SOLUTION for array](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_60/Merge_k_sorted_array_for_array.java)

- [SOLUTION for array](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_60/Merge_k_sorted_array_for_list.java)
- Time Complexity:
  1. Offer value in minHeap: O(k)
  2. offer and poll from heap : O(2logk) _ O(n _ k) = O(nklogk)
- Space Complexity: O(k)

> - 使用一个 minHeap 记录每个 sub sorted array 的第一个元素，然后 poll and add。

```java
PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(ar rayOfArrays.length, new Comparator<Cell>() {
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.val == c2.val) {
          return 0;
        }
        return c1.val < c2.val ? -1 : 1;
      }
    });
```

> - 新 class - Cell（row， col，val）

```java
static class Cell {
    int row;
    int col;
    int val;

    Cell(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }
```

## Problem 2 External sort.

> Given a single computer with a single CPU and a single core, which has 2GB of memory and 1GB available for use, it also has two 100GB hard drives. How to sort 80GB integers of 64 bits?

> 1. 首先把 80GB 的数据分成 800 份（大于 80 份，不然 1GB 的数据放入内存中，内存无法处理数据），然后对每份数据进行 sort，放入一个 hard drive。这样 hard drive 中每份都是 sorted。
> 2. 从每份中取出 1mb 放入 memory 中，（共 800mb），使用 k-way sort。
> 3. 每 1mb 的数据查完，就再放入下一个 1mb
> 4. 每 500mb 放入一次 hard drive

## Problem 3 2 sum to a target in 1TB data

> 1. do data sampling, 确定每一块 data 的数据量（50-55 一百个）
> 2. 对数据分块处理，将数据写入所在区域的文件中
> 3. 从头和尾取文件遍历查询

# Common Element Problem

## Find common elements in two arrays

> <mark>Clarify Duplicated, ascending/decending</mark>
>
> 1. two pointers, when it same, add to result and move together.
> 2. Otherwise, move the smallest.

## [Find common elements in k sorted arrays of similar size](https://app.laicode.io/app/problem/644)

> Method 1:
>
> - Use a minHeap and a int variable max, when minHeap.peek() == max, add to result then poll and offer next.
> - TC : O(nklogk)
> - SC : O(k)

> <Mark>Method 2: iterative</mark> recommend
>
> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_60/Common_Elements_In_K_Sorted_Lists.java)
> - Compare with each two, till the last one.
> - TC : O(nk)
> - SC : O(n)

> Method 3 : binary reduction(分奇偶，不好写，但是可以优化)
>
> - similar as Iterative method, but grouped by two
> - TC : O(nk)
> - SC : O(n)

<mark> 结果数量越来越多用 minheap，结果数量越来越少用 Iteration

# Histogram Question(直方图问题)

## [直方图下雨接水问题](https://app.laicode.io/app/problem/199)

> [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_60/Max_Water_Trapped_I.java)
> - 从左和右分别记录 leftMax 和 rightMax，
> - 用两个指针相向而行，当一方 Maxvalue 小的时候，累加 Sum，并移动

## [2D 直方图下雨接水问题](https://app.laicode.io/app/problem/200)

> [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_60/Max_Water_Trapped_II.java)
> - 将一周的 node 都加入到 minHeap 中
> - 用一个 boolean[][]记录 node 是否被访问过
> - poll 出一个，将所有没访问的 neighbors 加入 minHeap 中
## [查找一个list中有多少个点在一条直线上（斜率相等)](https://app.laicode.io/app/problem/216)
> [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_60/Most_Points_On_A_Line.java)
```java
for (int i = 0; i < points.length; i++) {
  // same 是list中有多少个node和第i个node一样，
  // sameX和most是在一行或者不在一行中还有多少个node一样
  // result 应该是 same + sameX / most
  int same = 1, sameX = 0, most = 0;
  Map<Double, Integer> map; // Double 为slope，integer为个数
  for (int j = 0; j < points.length; j++) {
    // 跳过相同的点
    if (i == j) {
      continue;
    }
    // update map
  }
  // for each i， update result
}
```

