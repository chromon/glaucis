/*
144. Binary Tree Preorder Traversal
Easy

Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [1,2]
Example 5:


Input: root = [1,null,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
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
    
    List<Integer> list = new ArrayList<>();
    
    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
    */
    
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();

        if(root != null) {
            s.push(root);
        }

        while(!s.empty()) {
            root = s.pop();

            list.add(root.val);

            // 每次都是弹出栈时被访问，所以应先将右子树推入栈中，后将左子树入栈
            // 以使得左子树先被访问
            if (root.right != null) {
                s.push(root.right);
            }

            if (root.left != null) {
                s.push(root.left);
            }
        }
        return list;
    }
}