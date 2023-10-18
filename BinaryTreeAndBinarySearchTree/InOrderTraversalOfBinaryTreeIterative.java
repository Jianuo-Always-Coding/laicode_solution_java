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
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                result.add(cur.key);
                cur = cur.right;
            }
        }
        return result;
    }
}
// TC : O(n)
// SC : O(1)
