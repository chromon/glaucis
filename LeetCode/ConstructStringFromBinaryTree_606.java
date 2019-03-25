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
    public String tree2str(TreeNode t) {
        
        if (t == null) {
            return "";
        }
        
        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }
        
        String left = "(" + tree2str(t.left) + ")";
        String right = tree2str(t.right);
        
        return String.valueOf(t.val) + left + (right == ""? "": "(" + right + ")");
    }
}