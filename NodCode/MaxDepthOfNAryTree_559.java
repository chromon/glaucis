/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        
        if (root == null) {
            return 0;
        }
        
        int max = 0;
        
        if (root.children != null) {
            for (Node n: root.children) {
                //max = Math.max(max, maxDepth(n));
                
                // 最大深度需要提前缓存出来
                int depth = maxDepth(n);
                max = max > depth ? max : depth;
            }
        }
        
        return max + 1;
    }
}