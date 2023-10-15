# Object-oriented Design
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
### Stack with min()

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
### Implement a Queue by 2 stack
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