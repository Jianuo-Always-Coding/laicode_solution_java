public class Solution {
    public int largestSmaller(TreeNode root, int target) {
      // Write your solution here
      int result = Integer.MIN_VALUE;
      TreeNode cur = root;
      while (cur != null) {
        if (cur.key < target) {
          result = cur.key;
          cur = cur.right;
        } else {
          cur = cur.left;
        }
      }
      return result;
    }
  }
  
  // TC : O(height)
  // SC : O(1)