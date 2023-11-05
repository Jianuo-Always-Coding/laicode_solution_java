/**
 * Implement a recursive, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.
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
public class PreOrderRecursion {
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    preOrder(root, result);
    return result;
  }

  private void preOrder(TreeNode root, List<Integer> result) {
    // base case
    if (root == null) {
      return ;
    }
    result.add(root.key);
    preOrder(root.left, result);
    preOrder(root.right, result);
  }  
}

// TC : O(N)
// SC : O(Height)