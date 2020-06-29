class Solution {
    public String removeOuterParentheses(String S) {
        
        // 用计数器open表示"栈"内左侧括号的数量
        StringBuffer ans = new StringBuffer();
        int open = 0;
        
        for (char ch : S.toCharArray()) {
            if (ch == ')') {
                open--;
            }
            if (open > 0) {
                ans.append(ch);
            }
            if (ch == '(') {
                open++;
            }
        }
        
        return ans.toString();
    }
}