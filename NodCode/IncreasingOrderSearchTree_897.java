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
    
    TreeNode node = new TreeNode(-1);
    TreeNode head = node;
    
    public TreeNode increasingBST(TreeNode root) {
        traverse(root);
        return node.right;
    }
    
    private void traverse(TreeNode root) {
        
        if (root != null) {
            traverse(root.left);
            
            head.right = new TreeNode(-1);
            head = head.right;
            head.val = root.val;
            
            traverse(root.right);
        } 
    }
}