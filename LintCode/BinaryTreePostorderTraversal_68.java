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
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    
    // non-recursive version
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        
        /*
            后序遍历，左节点先于右结点先于根节点被访问，因此，根先入栈，出栈时访问节点。
            若当前栈顶结点没有左孩子和右孩子或者左孩子节点和右孩子结点都被访问了，
            则直接访问当前栈顶结点。否则，当前栈顶结点、存在左孩子或右孩子，则依照先入右孩子结点，
            再入左孩子结点的顺序入栈。
        */
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root == null) {
            return list;
        }
        
        TreeNode cur = null;
        TreeNode pre = null;
        
        stack.push(root);
        
        while (! stack.isEmpty()) {
            cur = stack.peek();
            if (((cur.left == null) && (cur.right == null)) 
                || ((pre != null) && (pre == cur.left || pre == cur.right))) {
                // cur 栈顶元素为叶节点或者栈顶元素的左右节点已被访问过了，则直接访问栈顶元素
                list.add(cur.val);
                pre = cur;
                stack.pop();
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        
        return list;
    }
    
    // recursive version
    // List<Integer> list = new ArrayList<>();
    
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     // write your code here
        
    //     if(root == null) {
    //         return null;
    //     }
        
    //     postorderTraversal(root.left);
    //     postorderTraversal(root.right);
    //     list.add(root.val);
        
    //     return list;
    // }
}