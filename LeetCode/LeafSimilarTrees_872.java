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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> list1 = new ArrayList<>();
        traverse(list1, root1);
        List<Integer> list2 = new ArrayList<>();
        traverse(list2, root2);
        
        if (list1.size() != list2.size()) {
            return false;
        }
        
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void traverse(List<Integer> list, TreeNode root) {
        
        if (root != null) {
        
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }

            traverse(list, root.left);
            traverse(list, root.right);
        }
    }
}