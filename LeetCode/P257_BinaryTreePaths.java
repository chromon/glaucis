/*
257. Binary Tree Paths
Easy

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
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
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res = new ArrayList<>();
        ArrayDeque<TreeNode> nodeStack = new ArrayDeque<>();
        ArrayDeque<String> pathStack = new ArrayDeque<>();
        
        nodeStack.addFirst(root);
        pathStack.addFirst(String.valueOf(root.val));
        
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.removeFirst();
            String path = pathStack.removeFirst();
            
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            
            if (node.left != null) {
                nodeStack.addFirst(node.left);
                pathStack.addFirst(path + "->" + node.left.val);
            }
            
            if (node.right != null) {
                nodeStack.addFirst(node.right);
                pathStack.addFirst(path + "->" + node.right.val);
            }
        }
        
        return res;
    }
    /*
    
    List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        searchPath(root, "");
        return res;
    }
    
    private void searchPath(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        
        if (root.left != null) {
            searchPath(root.left, path + root.val + "->");
        }
        if (root.right != null) {
            searchPath(root.right, path + root.val + "->");
        }
    }
    */
}