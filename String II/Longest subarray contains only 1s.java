package String II;

public class Solution {
  public int longestConsecutiveOnes(int[] nums, int k) {
    // corner case
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int slow = 0;
    int fast = 0;
    int longest = 0;
    int meet0Nums = 0;
    
    while (fast < nums.length) {
      if (nums[fast] == 1) {
        fast++;
      } else if (meet0Nums == k) {
        while(nums[slow] != 0) {
          slow++;
        }
        slow++;
        fast++;
      } else {
        fast++;
        meet0Nums++;
      }
      longest = Math.max(longest, fast - slow);
    }
    return longest;
  }
}

// TC : O(n)
// SC : O(1)