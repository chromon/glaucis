/*
709. To Lower Case
Easy

Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

 

Example 1:

Input: s = "Hello"
Output: "hello"
Example 2:

Input: s = "here"
Output: "here"
Example 3:

Input: s = "LOVELY"
Output: "lovely"
 

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.
*/

class Solution {
    /*
    // 1 ms, faster than 35.35%
    public String toLowerCase(String s) {
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                c[i] += 32;
            }
        }
        return new String(c);
    }
    */
    
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}