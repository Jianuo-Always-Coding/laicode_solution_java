# Recursion

## Time complexity and Space Complexity

Analyze TC and SC must draw recursion tree in a recursion function.

The number of branches a tree has is determined by how many times a recursion function is called.

## Quick Sort

> - Math.random()  
>   Return a pseudorandom double type number greater than or equal to 0.0 and less than 1.0
```java
    int pivotIndex = left + (int)(Math.random() * (right - left + 1));
```
> - When call recursion function, we put the pivotVal back to the array, swap with the index left.

```java
    swap(array, l, right);
    quickSort(array, left, l - 1);
    quickSort(array, l + 1, right);
```