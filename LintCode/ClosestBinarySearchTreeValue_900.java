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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        int closest = root.val;
        
        while(root != null) {
            // 如果该节点的离目标更近，则更新到目前为止的最近值
            closest = Math.abs(closest - target) < Math.abs(root.val - target) ? closest : root.val;
            // 二叉搜索
            root = target < root.val ? root.left : root.right;
        }
        
        return closest;
    }
}