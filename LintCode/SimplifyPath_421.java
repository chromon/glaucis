public class Solution {
    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        // write your code here
        
        Stack<String> stack = new Stack<>();
        String[] sarr = path.split("/");
        
        for (String s: sarr) {
            if (s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                stack.pop();
            } else {
                stack.push(s);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder res = new StringBuilder();
        while (! stack.isEmpty()) {
            if (stack.peek().equals("")) {
                stack.pop();
            } else {
                res.insert(0, "/" + stack.pop());
            }
        }
        
        // 处理/.情况
        return res.length() == 0? "/": res.toString();
    }
}