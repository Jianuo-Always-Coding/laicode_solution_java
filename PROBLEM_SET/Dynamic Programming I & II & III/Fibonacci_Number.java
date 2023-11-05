package Dynamic Programming I & II & III;

public class Solution {
  public long fibonacci(int K) {
    // Write your solution here
    // corner case
    if (K < 0) {
      return 0;
    }
    if (K <2) {
      return K;
    }
    long a = 0;
    long b = 1;
    for (int i = 2; i <= K; i++) {
      long temp = a + b;
      a = b;
      b = temp;
    }
    return b;
  }
}

// TC : O(n)
// SC : O(1)
