# Deque & Queue

## Sort With 2 Stacks

Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).

```java
    public class Solution {
        public void sort(LinkedList<Integer> s1) {
            LinkedList<Integer> s2 = new LinkedList<Integer>();
            ...

        }
    }
```

Because this we need 2 stack, but the input is LinkedList, so we need to create a function use interface to convert the type.

```java
    public class Solution {
        public void sort(LinkedList<Integer> s1) {
            LinkedList<Integer> s2 = new LinkedList<Integer>();
            // corner case
            if (s1 == null || s1.size() <= 1) {
                return ;
            }
            sort(s1, s2);
            return ;
        }

        private void sort(Deque<Integer> s1, Deque<Integer> s2) {
            ...
        }
    }
```

## Stack (Practice 6)

```java
public class Stack {
    public Integer pop();
    public Integer peek();
    public boolean push();
    public int size();
    public boolean isEmpty();
}
```

### Implement a Stack with Linked List (uncompleted)

### Implement a bounded Stack with ArrayList (uncompleted)

### [Stack with min()](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/DequeAndQueue/StackWithMin.java)

### [Stack by a Queue](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/DequeAndQueue/StackByQueue.java)

## Queue (Practice 6)

```java
public class Queue {
    public Integer offer();
    public Integer peek();
    public boolean poll();
    public int size();
    public boolean isEmpty();
}
```

### Implement a Queue with Linked List (uncompleted)

### Implement a bounded Queue with ArrayList (uncompleted)

### [Implement a Queue by 2 stack](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/DequeAndQueue/QueueByTwoStacks.java)

```java
public class QueueByTwoStacks {
    private Deque<Integer> in;
    private Deque<Integer> out;


    // constructor
    public QueueByTwoStacks() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }
    ...
}
```

We needn't to keep a variable 'size' to keep the queue size. Just do this.

```java
public int size() {
    return in.size() + out.size();
}

public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
}
```

## Deque

### [Implement a Deque By Three Stacks](https://github.com/Jianuo-Always-Coding/laicode_solution_java/blob/main/DequeAndQueue/DequeByThreeStacks.java)
