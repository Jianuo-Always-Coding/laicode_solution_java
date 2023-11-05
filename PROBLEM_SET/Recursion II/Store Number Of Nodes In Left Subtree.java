package Recursion II;

/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    findNum(root);
  }

  private int findNum(TreeNodeLeft root) {
    // base case
    if (root == null) {
      return 0;
    }
    root.numNodesLeft = findNum(root.left);
    return root.numNodesLeft + findNum(root.right) + 1;
  }
}

// TC : O(n)
// SC : O(height)

