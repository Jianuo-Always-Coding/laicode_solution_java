package GraphSearchIBFS;

public class Check_If_Binary_Tree_Is_Completed {
    public boolean isCompleted(TreeNode root) {
        // corner case
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean seenNull = false;

        // corner case
        if (root == null) {
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    if (seenNull) {
                        return false;
                    }
                } else if (!seenNull) {
                    seenNull = true;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    if (seenNull) {
                        return false;
                    }
                } else if (!seenNull) {
                    seenNull = true;
                }
            }
        }
        return true;
    }
}
// TC : O(n)
// SC : O(n)