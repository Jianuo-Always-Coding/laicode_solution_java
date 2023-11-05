package Recursion;

public class FibonacciNumberLiteRecursion {
    public int fibonacci(int K) {
        // Write your solution here
        // corner case
        if (K < 0) return 0;
        if (K == 0 || K == 1) {
          return K;
        }
    
        return fibonacci(K - 1) + fibonacci(K - 2);
    }
}


// TC : O(2 ^ n)
// SC : O(n)