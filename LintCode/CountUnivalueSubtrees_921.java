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
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    int count = 0; 
     
    public int countUnivalSubtrees(TreeNode root) {
        // write your code here
        if(root == null) {
            return 0;
        }
        
        isUnival(root);
        
        return count;
    }
    
    public boolean isUnival(TreeNode root) {
        
        boolean uni = true;
        
        if (root.left != null) {
            uni = uni & (isUnival(root.left) && (root.val == root.left.val));
        }
        
        if(root.right != null) {
            uni = uni & (isUnival(root.right) && (root.val == root.right.val));
        }
        
        if(uni) {
            count++;
        }
        
        return uni;
    }
}