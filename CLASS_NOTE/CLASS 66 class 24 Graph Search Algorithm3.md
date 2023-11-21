# Class 24 Graph Search Algorithm
## BFS in Implicit(隐式) Graph
### [Problem 1 Seven Pazzle](https://app.laicode.io/app/problem/681)
Given eight cards with number 0, 1, 2, ..7 on them, the cards are placed in two rows with 4 cards in each row. In each step only card 0 could swap with one of its adjacent(top, right, bottom, left) card. Your goal is to make all cards placed in order like this:(每次只能让0和其中一个数字交换)



> - 使用图论的想法
  - Time complexity : O(V + E)
  - V : n! (每个位置都可能放8个点中的一个)
  - E : n! * 3 （每个状态可以改变为3种不同的状态）