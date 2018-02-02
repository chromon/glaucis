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
        
        if(root == null) {
            return list;
        }
        
        // offer == enqueue
        q.offer(root);
        int i = 0;
        i ++;

        while (!q.isEmpty()) {

            List<Integer> integerList = new ArrayList<>();
            i = q.size();
            
            while(i > 0) {
                // poll == dequeue
                root = q.poll();
                i --;
                
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