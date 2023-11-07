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
  public TreeNode flatten(TreeNode root) {
    // corner case
    if (root == null) {
      return root;
    }

    TreeNode[] prev = new TreeNode[1];
    helper(root, prev);
    return root;
  }

  private void helper(TreeNode root, TreeNode[] prev) {
    // base case
    if (root == null) {
      return ;
    }

    TreeNode leftTree = root.left;
    TreeNode rightTree = root.right;
    if (prev[0] != null) {
      prev[0].right = root;
    }
    root.left = null;
    prev[0] = root;
    helper(leftTree, prev);
    helper(rightTree, prev);
  }
}

// TC : O(n)
// SC : O(1)
