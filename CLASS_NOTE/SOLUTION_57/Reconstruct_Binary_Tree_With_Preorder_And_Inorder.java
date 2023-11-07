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
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0;  i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return helper(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, map);
  }

  private TreeNode helper(int[] inOrder, int inLeft, int inRight, int[] preOrder, int preLeft, int preRight, Map<Integer, Integer> map) {
    if (inLeft > inRight) {
      return null;
    }

    TreeNode newNode = new TreeNode(preOrder[preLeft]);
    int indexRoot = map.get(preOrder[preLeft]);
    int leftNumbers = indexRoot - inLeft;
    newNode.left = helper(inOrder, inLeft, indexRoot - 1, preOrder, preLeft + 1, preLeft + leftNumbers, map);
    newNode.right = helper(inOrder, indexRoot + 1, inRight, preOrder, preLeft + leftNumbers + 1, preRight, map);
    return newNode;
  }
}
