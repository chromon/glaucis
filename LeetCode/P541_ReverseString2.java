/*
541. Reverse String II
Easy

Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
*/


class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i += 2 * k) {
            int a = i;
            int b = Math.min(i + k - 1, c.length - 1);
            
            while (a < b) {
                char tmp = c[a];
                c[a] = c[b];
                c[b] = tmp;
                
                a++;
                b--;
            }
        }
        return new String(c);
    }
}