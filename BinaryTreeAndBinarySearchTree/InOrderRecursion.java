package BinaryTreeAndBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Implement a recursive, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.
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
public class InOrderRecursion {
  public List<Integer> inOrder(TreeNode root) {
    // 需要返回List<Integer>，新建一个
    List<Integer> result = new ArrayList();
    helper(root, result);
    return result;
  }

  private void helper(TreeNode root, List<Integer> result) {
    // base case
    if(root == null) {
      return;
    }
    helper(root.left, result);
    result.add(root.key);
    helper(root.right, result);
    return ;
  }
}

// TC : O(N)
// SC : O(Height)