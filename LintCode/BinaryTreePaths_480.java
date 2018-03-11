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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        ArrayList<String> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        
        String path = "";
        paths(root, result, path);
        
        return result;
    }


    public void paths(TreeNode root, ArrayList<String> result, String path){ 
        
        if(root == null) {
            return;
        }
        
        if(path.equals("")) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }
        
        if(root.left == null && root.right == null) {
            result.add(path);
        }

        paths(root.left, result, path);
        paths(root.right, result, path);
    }
    
    /*
    public void paths(TreeNode root, ArrayList<String> result, String path){
        
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null){
            if(path.equals("")) {
                path += root.val;
            } else {
                path += "->" + root.val;
            }
            
            result.add(path);
            return;
        }
        
        if(path.equals("")) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }
        
        paths(root.left, result, path);
        paths(root.right, result, path);
        
    }
    */
}