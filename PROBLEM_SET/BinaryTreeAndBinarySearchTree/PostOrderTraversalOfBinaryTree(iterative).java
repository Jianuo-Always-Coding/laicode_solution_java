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
public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    // corner case
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    TreeNode prev = null;
    TreeNode cur = null;

    while (!stack.isEmpty()) {
      cur = stack.peekFirst();
      // start case & from root to child
      if (prev == null || cur == prev.left || cur == prev.right) {
        // have left add left
        if (cur.left != null) {
          stack.offerFirst(cur.left);
        // else have right add right
        } else if (cur.right != null) {
          stack.offerFirst(cur.right);
        // no child return 
        } else {
          result.add(cur.key);
          stack.pollFirst();
        }
      } else if (prev == cur.left) {
        if (cur.right == null) {
          result.add(cur.key);
          stack.pollFirst();
        } else {
          stack.offerFirst(cur.right);
        }
      } else {
        result.add(cur.key);
        stack.pollFirst();
      }
      prev = cur;
    }
    return result;
  }
}
