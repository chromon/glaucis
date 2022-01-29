/*
17. Letter Combinations of a Phone Number
Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

class Solution {
    
    /*
        回溯过程中维护一个字符串，表示已有的字母排列。该字符串初始为空。每次取电话号码的一位数字，
        从 String 数组中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有字母排列后面，
        然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。
        然后进行回退操作，遍历其余的字母排列。
    */
    public List<String> letterCombinations(String digits) {
        
        String[] arr = new String[] {"", "", "abc", "def", "ghi", "jkl", 
                                     "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        
        if (digits.length() == 0) {
            return res;
        }

        backtrace(arr, res, digits, 0, new StringBuilder());
        
        return res;
    }
    
    private void backtrace(String[] arr, List<String> res, String digits,
                           int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
        } else {
            String s = arr[digits.charAt(index) - '0'];
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                backtrace(arr, res, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}