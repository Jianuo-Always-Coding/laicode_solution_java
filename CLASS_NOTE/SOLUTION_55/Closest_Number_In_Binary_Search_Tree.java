/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
    public int closest(TreeNode root, int target) {
      TreeNode cur = root;
      // If this is equal Integer.MIN_VALUE / MAX_VALUE, it will overflow in the following operation
      // Math.abs(result - target)
      // so here result must equal to root.key, because root.key may be result
      int result = root.key;
      while (cur != null) {
        if (cur.key == target) {
          return cur.key;
        } else {
          if (Math.abs(cur.key - target) < Math.abs(result - target)) {
            result = cur.key;
          }
  
          if (cur.key > target) {
            cur = cur.left;
          } else {
            cur = cur.right;
          }
        }
      }
      return result;
    }
  }
  
  // TC : O(height)
  // SC : O(1)