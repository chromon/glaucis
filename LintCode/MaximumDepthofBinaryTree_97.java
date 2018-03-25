/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null) {
            return 0;
        }
        
        if(root.left == null) {
            return maxDepth(root.right) + 1;
        }
        
        if(root.right == null) {
            return maxDepth(root.left) + 1;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return leftDepth < rightDepth? rightDepth + 1: leftDepth + 1;
    }
}