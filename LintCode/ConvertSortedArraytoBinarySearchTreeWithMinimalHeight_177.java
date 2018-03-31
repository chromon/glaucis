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
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        
        if(A.length == 0) {
            return null;
        }
        
        TreeNode t = null;
        return createNode(t, A, 0, A.length - 1);
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