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
    public void flatten(TreeNode root) {
        
        if (root != null) {
            flatten(root.left);
            flatten(root.right);
            
            TreeNode node = root.right;
            root.right = root.left;
            root.left = null;
            
            while (root.right != null) {
                root = root.right;
            }
            
            root.right = node;
        }
    }
}