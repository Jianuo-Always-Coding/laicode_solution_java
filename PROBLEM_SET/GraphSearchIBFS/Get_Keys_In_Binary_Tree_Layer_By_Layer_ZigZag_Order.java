package GraphSearchIBFS;


public class Get_Keys_In_Binary_Tree_Layer_By_Layer_ZigZag_Order {
  public List<Integer> zigZag(TreeNode root) {
    // corner case
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offerFirst(root);
    boolean time = true;

    while (!deque.isEmpty()) {
      if (time) {
        leftIn(deque, result);
        time = false;
      } else {
        rightIn(deque, result);
        time = true;
      }
    }
    return result;
  }

  private void leftIn(Deque<TreeNode> deque, List<Integer> result) {
    int size = deque.size();
    for (int i = 0; i < size; i++) {
      TreeNode cur = deque.pollLast();
      result.add(cur.key);
      if (cur.right != null) {
        deque.offerFirst(cur.right);
      }
      if (cur.left != null) {
        deque.offerFirst(cur.left);
      }
    }
  }

  private void rightIn(Deque<TreeNode> deque, List<Integer> result) {
    int size = deque.size();
    for (int i = 0; i < size; i++) {
      TreeNode cur = deque.pollFirst();
      result.add(cur.key);
      if (cur.left != null) {
        deque.offerLast(cur.left);
      }
      if (cur.right != null) {
        deque.offerLast(cur.right);
      }
    }
  }
}
