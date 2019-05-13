/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    
    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inorderTraversal(root);
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            queue.offer(root.val);
            inorderTraversal(root.right);
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */