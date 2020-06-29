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
    
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        inOrderTraverse(root);
        return root;
    }
    
    private void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.right);
            sum += root.val;
            root.val = sum; 
            inOrderTraverse(root.left);
        }
    }
}