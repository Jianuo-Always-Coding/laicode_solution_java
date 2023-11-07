package CLASS_NOTE.SOLUTION_57;

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
  public TreeNode reconstruct(int[] post) {
    // Write your solution here
    return helper(post, 0, post.length - 1);
  }

  private TreeNode helper(int[] post, int left, int right) {
    // corner case
    if (left > right) {
      return null;
    }
    TreeNode newNode = new TreeNode(post[right]);
    int rightFirst = left;
    while (rightFirst < right && post[rightFirst] < post[right]) {
      rightFirst++;
    }

    newNode.left = helper(post, left, rightFirst - 1);
    newNode.right = helper(post, rightFirst, right - 1);
    return newNode;
  }
  
}

