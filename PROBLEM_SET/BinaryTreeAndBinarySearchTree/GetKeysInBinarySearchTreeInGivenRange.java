package BinaryTreeAndBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.
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
public class GetKeysInBinarySearchTreeInGivenRange {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    helper(root, result, min, max);
    return result;
  }

  private void helper(TreeNode root, List<Integer> result, int min, int max) {
    // base case
    if (root == null) {
      return ;
    }
    if (root.key < min) {
      helper(root.right, result, min, max);
    } else if (root.key >= min && root.key <= max) {
      helper(root.left, result, min, max);
      result.add(root.key);
      helper(root.right, result, min, max);
    } else {
      helper(root.left, result, min, max);
    }
    return ;
  }
}
// TC : O(n)
// SC : O(height)
