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
     * @param root: the root of tree
     * @return: the max node
     */
        
    TreeNode max = new TreeNode(Integer.MIN_VALUE);
    
    public TreeNode maxNode(TreeNode root) {
        // write your code here
        
        if(root == null) {
            return null;
        }
        
        max = max.val > root.val? max: root;
        maxNode(root.left);
        maxNode(root.right);
        
        return max;
    }
}