/*
1022. Sum of Root To Leaf Binary Numbers
Easy

You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a 32-bits integer.

 

Example 1:


Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
Example 2:

Input: root = [0]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
Node.val is 0 or 1.
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
    
    /*
    List<Integer> res = new ArrayList<>();
    
    public int sumRootToLeaf(TreeNode root) {
        searchPath(root, 0);
        
        int sum = 0;
        for (int r: res) {
            sum += r;
        }
        
        return sum;
    }
    
    private void searchPath(TreeNode root, int n) {
        if (root.left == null && root.right == null) {
            res.add(n * 2 + root.val);
        }
        
        if (root.left != null) {
            searchPath(root.left, n * 2 + root.val);
        }
        if (root.right != null) {
            searchPath(root.right, n * 2 + root.val);
        }
    }
    */
    
    int res = 0;
    
    public int sumRootToLeaf(TreeNode root) {
        searchPath(root, 0);
        return res;
    }
    
    private void searchPath(TreeNode root, int n) {
        if (root.left == null && root.right == null) {
            res += n * 2 + root.val;
        }
        
        if (root.left != null) {
            searchPath(root.left, n * 2 + root.val);
        }
        if (root.right != null) {
            searchPath(root.right, n * 2 + root.val);
        }
    }
    
}