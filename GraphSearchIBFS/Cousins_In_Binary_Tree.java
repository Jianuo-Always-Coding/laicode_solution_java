package GraphSearchIBFS;

public class Cousins_In_Binary_Tree {

    public boolean isCousin(TreeNode root, int a, int b) {
        // corner case
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean aSeen = false;
            boolean bSeen = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null && cur.right != null) {
                    if ((cur.left.key == a && cur.right.key == b) || (cur.left.key == b && cur.right.key == a)) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.key == a) {
                    aSeen = true;
                }
                if (cur.key == b) {
                    bSeen = true;
                }
                if (aSeen && bSeen) {
                    return true;
                }
            }
        }
        return false;
    }
}

// TC : O(n)
// SC : O(n)
