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
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }
        
        if(! isBalanced(root.left)) {
            return false;
        }
        
        if(! isBalanced(root.right)) {
            return false;
        }
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        if(Math.abs(left - right) > 1) {
            return false;
        }
        
        return true;
    }
    
    public int depth(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}