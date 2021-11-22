/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
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

/*
    通过中序遍历根节点位置计算先序遍历中左右子树位置

    preorder: |  root  |    root.left     |    root.right      |
              |    1   |  index-inStart   |                    |
    
          preStart preStart+1    preStart+(index-inStart)    preEnd
    
    inorder:  |    root.left    |  root  |      root.right     |
    
              |  index-inStart  |    1   |                     |
                                 
            inStart          index-1  index+1                inEnd
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        
        // 查找中序遍历时根节点索引位置
        int rootVal = preorder[preStart];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        
        // 递归构造左右子树
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + (index - inStart), 
                         inorder, inStart, index - 1);
        root.right = build(preorder, preStart + (index - inStart) + 1, preEnd,
                         inorder, index + 1, inEnd);
        
        return root;
    }
}