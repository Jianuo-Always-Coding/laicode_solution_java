package BinaryTreeAndBinarySearchTree;

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
public class InsertInBinarySearchTree {
  public TreeNode insert(TreeNode root, int key) {
    // corner case
    TreeNode newNode = new TreeNode(key);
    if (root == null) {
      return newNode;
    }
    if (root.key < key) {
      root.right = insert(root.right, key);
    } else if (root.key > key) {
      root.left = insert(root.left, key);
    }
    return root;
  }
}

// TC : o(height)
// SC : O(height)
