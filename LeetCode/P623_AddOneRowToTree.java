/*
623. Add One Row to Tree
Medium

Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 

Example 1:


Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]
Example 2:


Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
The depth of the tree is in the range [1, 104].
-100 <= Node.val <= 100
-105 <= val <= 105
1 <= depth <= the depth of tree + 1
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
    
    // 当输入 depth 为 1 时，需要创建一个新的 root，并将原 root 作为新 root 的左子节点。
    // 当 depth 为 2 时，需要在 root 下新增两个节点 left 和 right 作为 root 的新子节点，
    // 并把原左子节点作为 left 的左子节点，把原右子节点作为 right 的右子节点。
    // 当 depth 大于 2 时，需要继续递归往下层搜索，并将 depth 减去 1，直到搜索到 depth 为 2
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        
        return root;
    }
    
    /*
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 0 || depth == 1) {
            TreeNode t = new TreeNode(val);
            
            if (depth == 1) {
                t.left = root;
            } else {
                t.right = root;
            }
            
            return t;
        }
        
        if (root != null && depth > 1) {
            root.left = addOneRow(root.left, val, depth > 2 ? depth - 1 : 1);
            root.right = addOneRow(root.right, val, depth > 2 ? depth - 1 : 0);
        }
        
        return root;
    }
    */
}