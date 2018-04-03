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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        
        // 递归
        // if(root == null) {
        //     return;
        // }
        
        // TreeNode t = root.left;
        
        // root.left = root.right;
        // root.right = t;
        
        // invertBinaryTree(root.left);
        // invertBinaryTree(root.right);
        
        
        // 非递归
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root != null) {
            queue.offer(root);
        }
        
        while(! queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            
            TreeNode t = tmp.left;
            tmp.left = tmp.right;
            tmp.right = t;
            
            if(tmp.left != null) {
                queue.offer(tmp.left);
            }
            
            if(tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        
    }
}