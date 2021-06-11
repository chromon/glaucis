/*
113. Path Sum II
Medium

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        dfs(root, 0, targetSum, path);
        return res;
    }
    
    public void dfs(TreeNode root, int currentSum, int sum, ArrayList<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null && (currentSum + root.val) == sum) {
            res.add(new ArrayList<>(list));
            return;
        } 
        
        if (root .left != null) {
            dfs(root.left, currentSum + root.val, sum, list);
            list.remove(list.size() - 1);
        }
        
        if (root.right != null) {
            dfs(root.right, currentSum + root.val, sum , list);
            list.remove(list.size() - 1);
        }
    }
}