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
    
    List<Integer> treeList = new ArrayList<>();
    
    /*
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        if(root == null) {
            return null;
        }
        inorderTraversal(root.left);
        treeList.add(root.val);
        inorderTraversal(root.right);
        return treeList;
    }
}