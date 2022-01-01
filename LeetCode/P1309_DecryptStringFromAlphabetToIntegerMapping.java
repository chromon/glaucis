/*
1309. Decrypt String from Alphabet to Integer Mapping
Easy

You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.

 

Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
 

Constraints:

1 <= s.length <= 1000
s consists of digits and the '#' letter.
s will be a valid string such that mapping is always possible.
*/

class Solution {
    public String freqAlphabets(String s) {
        
        StringBuilder res = new StringBuilder();
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (c == '#') {
                String val = s.charAt(i - 2) + "" + s.charAt(i - 1);
                res.insert(0, (char) (Integer.parseInt(val) + 96));
                i -= 2;
            } else {
                res.insert(0, (char) (Integer.parseInt(String.valueOf(c)) + 96));
            }
        }
        
        return res.toString();
    }
}