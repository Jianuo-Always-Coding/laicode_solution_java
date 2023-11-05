package BinaryTreeAndBinarySearchTree;

/**
 * Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.
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
public class PreOrderTraversalOfBinaryTreeIterative {
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    // corner case
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      result.add(cur.key);
      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
      if (cur.left != null) {
        stack.offerFirst(cur.left);
      }
    }
    return result;
  }
}

// TC : O(n)
// SC : O(1)
