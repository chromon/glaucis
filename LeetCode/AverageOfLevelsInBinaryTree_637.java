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
    public List<Double> averageOfLevels(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        
        if (root != null) {
            queue.offer(root);
        } else {
            return res;
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int t = size;
            double sum = 0;
            
            while (t-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                
                if (node.left != null) {
                    queue.offer(node.left);
                } 
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
                
            res.add(sum / size);
        }
        
        return res;
    }
}