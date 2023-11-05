package BinaryTreeAndBinarySearchTree;

/**
 * Implement a recursive, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.
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
public class PostOrderRecursion {
  public List<Integer> postOrder(TreeNode root) {
    // 需要返回List<Integer>，新建一个
    List<Integer> result = new ArrayList();
    helper(root, result);
    return result;
  }

  private void helper(TreeNode root, List<Integer> result) {
    // base case
    if(root == null) {
      return ;
    }
    helper(root.left, result);
    helper(root.right, result);
    result.add(root.key);
    return ;
  }
}

// TC : O(n)
// SC : O(Height)