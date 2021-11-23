/*
1373. Maximum Sum BST in Binary Tree
Hard

Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:



Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
Example 2:



Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
Example 3:

Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.
Example 4:

Input: root = [2,1,3]
Output: 6
Example 5:

Input: root = [5,4,8,3,null,6,3]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 4 * 104].
-4 * 104 <= Node.val <= 4 * 104
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
    
    // BST 最大节点之和
    int maxSum = 0;
    
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }
    
    private Info traverse(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        // 后序遍历
        // 递归计算左右子树
        Info left = traverse(root.left);
        Info right = traverse(root.right);
        
        Info res = new Info();
        
        if (left.isBST && right.isBST
                && root.val > left.maxVal && root.val < right.minVal) {
            // 以 root 为根的二叉树是 BST
            res.isBST = true;
            // 计算以 root 为根的这棵 BST 的最小值
            res.minVal = Math.min(left.minVal, root.val);
            // 计算以 root 为根的这棵 BST 的最大值
            res.maxVal = Math.max(right.maxVal, root.val);
            // 计算以 root 为根的这棵 BST 所有节点之和
            res.nodeSum = left.nodeSum + right.nodeSum + root.val;
            
            maxSum = Math.max(maxSum, res.nodeSum);
        } else {
            // 以 root 为根的二叉树不是 BST
            // 其他值都不需要计算了
            res.isBST = false;
        }
        
        return res;
    }
}

class Info {
    // 以 root 为根的二叉树是否是 BST
    boolean isBST;
    // 以 root 为根的二叉树所有节点中的最小值
    int minVal;
    // 以 root 为根的二叉树所有节点中的最大值
    int maxVal;
    // 以 root 为根的二叉树所有节点值之和
    int nodeSum;
    
    public Info() {}
    
    public Info(boolean isBST, int minVal, int maxVal, int nodeSum) {
        this.isBST = isBST;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.nodeSum = nodeSum;
    }
}