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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        iterator(root, list, "");
        return list;
    }
    
    public void iterator(TreeNode root, List<String> list, String string){
        string += root.val + " ";
        
        if (root.left == null && root.right == null) {
            list.add(string.trim().replace(" ","->"));
        }
 
        if (root.left != null) {
            iterator(root.left, list, string);
        }
 
        if (root.right != null) {
            iterator(root.right, list, string);
            
        }
 
    }
}