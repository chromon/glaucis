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
    
    public boolean isUnivalTree(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        if ((root.left != null && root.val != root.left.val) ||
            (root.right != null && root.val != root.right.val)) {
            return false;
        } else {
            return isUnivalTree(root.left) && isUnivalTree(root.right);
        }
    }
}