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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        
        TreeNode t = null;
        return createNode(t, nums, 0, nums.length - 1);
    }
    
    public TreeNode createNode(TreeNode t, int[] a, int lo, int hi) {
        
        if(lo > hi) {
            return null;
        }
        
        t = new TreeNode(0);
        int mid = lo + (hi - lo) / 2;
        t.val = a[mid];
        
        t.left = createNode(t.left, a, lo, mid - 1);
        t.right = createNode(t.right, a, mid + 1, hi);
        
        return t;
    }
}