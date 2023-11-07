package CLASS_NOTE.SOLUTION_57;

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
  public int maxPathSumLeafToRoot(TreeNode root) {
    // base case
    if (root.left == null && root.right == null) {
      return root.key;
    } else if (root.left == null) {
      int rightVal = maxPathSumLeafToRoot(root.right);
      return rightVal + root.key;
    } else if (root.right == null) {
      int leftVal = maxPathSumLeafToRoot(root.left);
      return leftVal + root.key;
    }
    int leftVal = maxPathSumLeafToRoot(root.left);
    int rightVal = maxPathSumLeafToRoot(root.right);    
    return root.key + Math.max(leftVal, rightVal);
  }
}

// TC : O(n)
// SC : O(height)