package BinaryTreeAndBinarySearchTree;

import javax.swing.tree.TreeNode;

/**
 * Find the height of binary tree.
 */

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

public class HeightOfBinaryTree {
  public int findHeight(TreeNode root) {
    // corner case & base case
    if (root == null) {
      return 0;
    }
    return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
  }
}

// TC : O(n)
// Sc : O(height)
