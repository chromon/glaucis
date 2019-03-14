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
    public List<List<Integer>> levelOrder(Node root) {
        
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        if (root != null) {
            queue.offer(root); 
        }
        
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            
            int size = queue.size();
            
            while (size > 0) {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
                size--;
            }
            
            res.add(list);
        }
        
        return res;
    }
}