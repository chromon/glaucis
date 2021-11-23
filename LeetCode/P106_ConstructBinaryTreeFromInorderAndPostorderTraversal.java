/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Medium

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
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
    通过中序遍历根节点位置计算后序遍历中左右子树位置

    preorder: |  root  |    root.left     |    root.right      |
              |    1   |  index-inStart   |                    |
    
          preStart preStart+1    preStart+(index-inStart)    preEnd
    
    inorder:  |    root.left    |  root  |      root.right     |
    
              |  index-inStart  |    1   |                     |
                                 
            inStart          index-1  index+1                inEnd
    
    postorder:|    root.left    |      root.right      |  root |
   
              |  index-inStart  |                      |    1  |
              
         postStart                                  postEnd-1
*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        // 查找中序遍历时根节点索引位置
        int rootVal = postorder[postEnd];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        
        // 递归构造左右子树
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, index - 1, 
                         postorder, postStart, postStart + index - inStart - 1);
        root.right = build(inorder, index + 1, inEnd, 
                         postorder, postStart + index - inStart, postEnd - 1);
        return root;
    }
}