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
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        paths(root, result, path, 0, target);
        
        return result;
    }
    
    public void paths(TreeNode root, List<List<Integer>> result, 
        List<Integer> path, int sum, int target){
        
        if(root == null) {
            return;
        }
        
        sum += root.val;
        path.add(root.val);
        
        if(sum == target && root.left == null && root.right == null) {
            result.add(path);
        }

        paths(root.left, result, new ArrayList<>(path), sum, target);
        paths(root.right, result, new ArrayList<>(path), sum, target);
    }
}