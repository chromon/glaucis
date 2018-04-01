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
     * @return: Postorder in ArrayList which contains node values.
     */
    
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        
        if(root == null) {
            return null;
        }
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        
        return list;
    }
}