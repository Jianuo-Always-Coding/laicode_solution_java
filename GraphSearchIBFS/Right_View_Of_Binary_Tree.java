package GraphSearchIBFS;

public class Right_View_Of_Binary_Tree {
  public List<Integer> rightView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    // corner case
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {

      int size = queue.size();
      for (int i = 0; i < size - 1; i++) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      TreeNode cur = queue.poll();
      result.add(cur.key);
      if (cur.left != null) {
          queue.offer(cur.left);
        }
      if (cur.right != null) {
        queue.offer(cur.right);
      }
    }
    return result;
  }
}
// TC : O(n)
// SC : O(n)