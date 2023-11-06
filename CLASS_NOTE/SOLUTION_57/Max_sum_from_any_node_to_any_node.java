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
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    int[] largestSum = new int[] {Integer.MIN_VALUE};
    helper(root, largestSum);
    return largestSum[0];
  }

  private int helper(TreeNode root, int[] largestSum) {
    // corner case
    if (root == null) {
      return 0;
    }

    int leftVal = Math.max(0, helper(root.left, largestSum));
    int rightVal = Math.max(0, helper(root.right, largestSum));
    largestSum[0] = Math.max(largestSum[0], root.key + leftVal + rightVal);
    return (leftVal > rightVal ? leftVal : rightVal) + root.key;
  }

}

// TC : O(n)
// SC : O(height)
