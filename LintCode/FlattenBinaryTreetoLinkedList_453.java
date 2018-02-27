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
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    TreeNode tmpNode = null;
     
    public void flatten(TreeNode root) {
        // write your code here
        if(root == null) {
            return;
        }
        
        if(tmpNode != null) {
            tmpNode.left = null;
            tmpNode.right = root;
        }
        
        tmpNode = root;
        TreeNode tmpRight = root.right;
        
        flatten(root.left);
        flatten(tmpRight);
    }
}