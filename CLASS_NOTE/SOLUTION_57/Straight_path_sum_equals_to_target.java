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
  public boolean exist(TreeNode root, int target) {
    // corner case
    if (root == null) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    boolean[] result = new boolean[] {false};
    set.add(0);
    helper(root, target, set, 0, result);
    return result[0];
  }

  private void helper(TreeNode root, int target, Set<Integer> set, int sum, boolean[] result) {
    // base case
    if (result[0] || root == null) {
      return ;
    }

    sum = sum + root.key;
    if (set.contains(sum - target)) {
      result[0] = true;
      return ;
    }
    boolean delete = set.add(sum);
    helper(root.left, target, set, sum, result);
    helper(root.right, target, set, sum, result);
    if (delete) {
      set.remove(sum);
    }
  }
}

// TC : O(n)
// SC : O(height)