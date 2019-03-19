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
    
    List<Integer> list = new ArrayList<>();
    
    public int getMinimumDifference(TreeNode root) {
        
        this.inOrderTraverse(root);
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i + 1) - list.get(i)) < min) {
                min = Math.abs(list.get(i + 1) - list.get(i));
            }
        }
        
        return min;
    }
    
    private void inOrderTraverse(TreeNode root) {
        
        if (root != null) {
            inOrderTraverse(root.left);
            list.add(root.val);
            inOrderTraverse(root.right);
        }
    }
}