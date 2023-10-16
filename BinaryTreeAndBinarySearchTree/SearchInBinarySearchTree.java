package BinaryTreeAndBinarySearchTree;

/**
 * Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.
 * 
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class SearchInBinarySearchTree {
  public TreeNode search(TreeNode root, int key) {
    // corner case
    if (root == null) {
      return null;
    }
    if (root.key == key) {
      return root;
    } else if (root.key < key) {
      return search(root.right, key);
    } 
    return search(root.left, key);
  }
}

// TC : O(height)
// SC : O(height)
