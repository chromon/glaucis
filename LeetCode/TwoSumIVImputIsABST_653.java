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
    
    List<Integer> list = new ArrayList<>();
    
    public boolean findTarget(TreeNode root, int k) {
        inOrderTraverse(root);
        
        for (int i = 0, j = list.size() - 1; i < j;) {
            if (list.get(i) + list.get(j) < k) {
                i++;
            } else if (list.get(i) + list.get(j) > k) {
                j--;
            } else {
                return true;
            }
        }
        
        return false;
    }
    
    private void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            list.add(root.val);
            inOrderTraverse(root.right);
        }
    }
}