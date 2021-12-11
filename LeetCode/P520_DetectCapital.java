/*
520. Detect Capital
Easy

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
*/


class Solution {
    
    // Accepted	1 ms faster than 99.59% 37.3 MB	java
    public boolean detectCapitalUse(String word) {
        
        char[] c = word.toCharArray();
        
        // first letter is capital?
        boolean j = false;
        // second letter is capital?
        boolean k = false;
        
        for (int i = 0; i < c.length; i++) {
            if (i == 0 && c[i] >= 65 && c[i] <= 90) {
                j = true;
            } else if (i == 1 && c[i] >= 65 && c[i] <= 90) {
                // aB
                if (!j) {
                    return false;
                }
                k = true;
            } else {
                // ABd
                if (j && k && c[i] >= 97 && c[i] <= 122) {
                    return false;
                }
                // AbD
                if (j && !k && c[i] >= 65 && c[i] <= 90) {
                    return false;
                }
                // abD
                if (!j && !k && c[i] >= 65 && c[i] <= 90) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /*
    // Accepted	9 ms faster than 6.59% 39.4 MB	java
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
    */
}