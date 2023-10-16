package BinaryTreeAndBinarySearchTree;

/**
 * Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.
 */

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *      this.key = key;
 *   }
 * }
 */

public class CheckIfBinaryTreeIsBalanced {
    public boolean isBalanced(TreeNode root) {
        // corner case
        if (root == null) {
            return true;
        }
        int height = helper(root);
        if (height == -1) {
            return false;
        }
        return true;
    }

    private int helper(TreeNode root) {
        // corner case
        if (root == null) {
            return 0;
        }
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if (leftHeight != -1 && rightHeight != -1) {
            if (Math.abs(leftHeight - rightHeight) <= 1) {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
        return -1;
    }
}

// TC : O(n)
// SC : O(Height)