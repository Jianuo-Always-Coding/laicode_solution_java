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
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    // Write your solution here
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      map.put(inOrder[i], i);
    }
    return helper(inOrder, 0, inOrder.length - 1, levelOrder, map);
  }

  private TreeNode helper(int[] inOrder, int inLeft, int inRight, int[] levelOrder, Map<Integer, Integer> map) {
    // base case
    if (inLeft > inRight) {
      return null;
    }

    int val = levelOrder[0];
    int indexRoot = map.get(val);
    TreeNode newNode = new TreeNode(val);
    int[] leftArray = new int[indexRoot - inLeft];
    int[] rightArray = new int[inRight - indexRoot];
    int leftIndex = 0;
    int rightIndex = 0;


    for (int i = 1; i < levelOrder.length; i++) {
      if (map.get(levelOrder[i]) < indexRoot) {
        leftArray[leftIndex++] = levelOrder[i];
      } else {
        rightArray[rightIndex++] = levelOrder[i];
      }
    }
    newNode.left = helper(inOrder, inLeft, indexRoot - 1, leftArray, map);
    newNode.right = helper(inOrder, indexRoot + 1, inRight, rightArray, map);
    return newNode;
  }
}
