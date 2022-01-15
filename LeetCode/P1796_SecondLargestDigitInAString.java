/*
1796. Second Largest Digit in a String
Easy

Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

 

Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
Example 2:

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit. 
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
*/

class Solution {
    public int secondHighest(String s) {
        
        int max = -1;
        int sec = -1;
        
        for (int i = 0; i < s.length(); i++) {
            int t = s.charAt(i);
            if (t >= 48 && t <= 57) {
                if (t - '0' > max) {
                    sec = max;
                    max = t - '0';
                } else if (t - '0' == max) {
                    continue;
                } else if (t - '0' > sec) {
                    sec = t - '0';
                }
            }
        }
        
        return sec;
    }
}