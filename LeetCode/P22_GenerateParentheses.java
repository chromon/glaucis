/*
22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

class Solution {
    
    // 剩余左括号总数要小于等于右括号。 递归回溯把所有符合要求的加上去即可。
    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        getParenthesis("", n, n);
        return res;
    }
    
    private void getParenthesis(String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        
        if (left == right) {
            // 剩余左右括号数相等，下一个只能用左括号
            // 使用 s + "(" 是为了保持 s 不变，实现回溯功能
            getParenthesis(s + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                // 剩余左括号小于右括号，下一个可以用左括号也可以用右括号
                getParenthesis(s + "(", left - 1, right);
            }
            
            getParenthesis(s + ")", left, right - 1);
        }
    }
}