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
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
     
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        
        if(root == null) {
            return null;
        }
        
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        
        return list;
    }
}