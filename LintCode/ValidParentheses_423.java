public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        
        Stack<Character> stack = new Stack<>();
        
        char[] c = s.toCharArray();
        
        for(int i = 0; i < c.length; i ++) {
            if(c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
            } else if((c[i] ==')' || c[i] == '}' || c[i] == ']') && (stack.isEmpty())) {
                return false;
            } else if(c[i] == ')') {
                char tc = stack.pop();
                if(tc != '(') {
                    return false;
                }
            } else if(c[i] == '}') {
                char tc = stack.pop();
                if(tc != '{') {
                    return false;
                }
            } else if(c[i] == ']') {
                char tc = stack.pop();
                if(tc != '[') {
                    return false;
                }
            }
        }
        
        if(! stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}