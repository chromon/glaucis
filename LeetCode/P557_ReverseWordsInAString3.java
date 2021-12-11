/*
557. Reverse Words in a String III
Easy

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
*/

class Solution {
    public String reverseWords(String s) {
        
        String[] strs = s.split(" ");
        
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            
            for (int a = 0, b = c.length - 1; a < b; a++, b--) {
                char tmp = c[a];
                c[a] = c[b];
                c[b] = tmp;
            }
            
            strs[i] = new String(c);
        }
        
        String space = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < strs.length; i++) {
            sb.append(space).append(strs[i]);
            space = " ";
        }
        
        return sb.toString();
    }
}