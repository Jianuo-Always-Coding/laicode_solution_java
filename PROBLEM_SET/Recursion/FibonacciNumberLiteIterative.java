package Recursion;

public class FibonacciNumberLiteIterative {
    public int fibonacci(int K) {
      // corner case
      if (K <= 0) return 0;
      if (K == 1) {
        return K;
      }
      int first = 0;
      int second = 1;
      int result = 0;
      for (int i = 2; i <= K; i++) {
        result = first + second;
        first = second;
        second = result;
      }
      return result;
    }
}

// TC : O(n)
// SC : O(1)
