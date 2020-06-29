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
    
    public int minDiffInBST(TreeNode root) {
        
        int min = Integer.MAX_VALUE;
        inOrder(root);
        
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) < min) {
                min = list.get(i + 1) - list.get(i);   
            }
        }
        
        return min;
    }
    
    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
}