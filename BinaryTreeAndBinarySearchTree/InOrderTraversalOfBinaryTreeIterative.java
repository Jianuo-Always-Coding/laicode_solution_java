package BinaryTreeAndBinarySearchTree;

/**
 * Implement an iterative, in-order traversal of a given binary tree, return the
 * list of keys of each node in the tree as it is in-order traversed.
 * 
 * public class TreeNode {
 * public int key;
 * public TreeNode left;
 * public TreeNode right;
 * public TreeNode(int key) {
 * this.key = key;
 * }
 * }
 */

public class InOrderTraversalOfBinaryTreeIterative {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // corner case
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode cur = root.left;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.left;
        }

        while (!stack.isEmpty()) {
            cur = stack.pollFirst();
            result.add(cur.key);

            if (cur.right != null) {
                stack.offerFirst(cur.right);
                if (cur.right.left != null) {
                    cur = cur.right.left;
                    while (cur != null) {
                        stack.offerFirst(cur);
                        cur = cur.left;
                    }
                }
            }
        }
        return result;
    }
}

// TC : O(n)
// SC : O(1)
