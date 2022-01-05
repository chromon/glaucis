/*
1417. Reformat The String
Easy

You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

 

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
*/

class Solution {
    public String reformat(String s) {
        
        StringBuilder cs = new StringBuilder();
        StringBuilder ds = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                ds.append(c);
            } else {
                cs.append(c);
            }
        }
        
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i < cs.length() && j < ds.length()) {
            sb.append(cs.charAt(i));
            sb.append(ds.charAt(j));
            i++;
            j++;
        }
        
        if (i == cs.length() - 1 && j == ds.length()) {
            sb.append(cs.charAt(i));
            i++;
        } else if (i == cs.length() && j == ds.length() - 1) {
            sb.insert(0, ds.charAt(j));
            j++;
        }
        
        if (i != cs.length() || j != ds.length()) {
            return "";
        }
        
        return sb.toString();
    }
}