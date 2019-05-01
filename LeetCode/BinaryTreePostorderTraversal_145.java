/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            
            if(node.left != null) {
                stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            }
            if(node.right != null) {
                stack.push(node.right);//后将右结点入栈
            }
            
            res.add(0,node.val);//逆序添加结点值
        }     
        
        return res;
    }
    
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        
        return list;
    }*/
}