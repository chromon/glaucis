/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        if (root.left != null && root.right != null) {
            return leftDepth > rightDepth ? rightDepth + 1 : leftDepth + 1;
        } 
        
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1; 
    }
}