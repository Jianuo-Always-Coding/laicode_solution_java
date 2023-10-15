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