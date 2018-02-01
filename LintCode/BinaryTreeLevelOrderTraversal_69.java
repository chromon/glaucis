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
    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        Queue<TreeNode> q = new LinkedList<>();
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // offer == enqueue
        q.offer(root);

        while (!q.isEmpty()) {

            List<Integer> integerList = new ArrayList<>();
            
            while(q.peek() != null) {
                // poll == dequeue
                root = q.poll();
                
                integerList.add(root.val);
    
                if (root.left != null) {
                    q.offer(root.left);
                }
    
                if (root.right != null) {
                    q.offer(root.right);
                }
            }
            
            list.add(integerList);
        }
        return list;
    }
}