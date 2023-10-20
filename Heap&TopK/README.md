# Heap & Top K

## Find K or Kth largest / smallest of number

> Find K largest, use a minHeap

## Find K or Kth largest / smallest of many arrays

> - Use a set to record the visited path, because in many cases, we need to return back to check. Every time poll from a minHeap, we found a smallest or largest number.
> - The minHeap size should be 2 \* k. Because every time, we poll a node, we will add 3 other node.

## Kth Smallest With Only 3, 5, 7 As Factors

> Because each time we can access 3 bigger number, we just need to poll and add other 3 node, do k - 1 times. Then the top of ninHeap is what we want.

## Kth Smallest Number In Sorted Matrix

- Create a new type of class - Cell
```java
static class Cell{
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
- Use a boolean array to record whether the node is visited
- Each time go right and go down.