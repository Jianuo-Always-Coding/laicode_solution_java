# [K-smallest in 2 arrays -Binary Search](https://app.laicode.io/app/problem/202)

> [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_64/Kth_Smallest_In_Two_Sorted_Arrays.java)
> - 每次砍掉一半的数量
> - 当一方数量小于 k/2 时，直接在长的一方砍掉 k/2

```java
int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
if (aval < bval) {
    aleft = amid + 1;
} else {
    bleft = bmid + 1;
}
```

# Problem of Hybrid Data Structure
## [LRU(Least Recent Used Cache)](https://app.laicode.io/app/problem/205?plan=3)
Implement a least recently used cache. It should provide set(), get() operations. If not exists, return null (Java),
> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_64/LRU_Cache.java)
> - Implement a class(Node) which is a doubly linked List
> - Use a map with doubly linked list
> - Helper function - append()/remove() only focus on append or remove in map and List

##  [First Non-Repeating Character In Stream](https://app.laicode.io/app/problem/288)
> - [SOLUTION](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/CLASS_NOTE/SOLUTION_64/First_NonRepeating_Character_In_Stream.java)
> - <mark>一定要注意append和remove传入的是Node，不是char，要对指定的node进行删除或者插入</mark>

Majority Number I