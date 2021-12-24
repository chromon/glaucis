/*
917. Reverse Only Letters
Easy

Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
*/

class Solution {
    public String reverseOnlyLetters(String s) {
        
        char[] c = s.toCharArray();
        
        for (int i = 0, j = c.length - 1; i < j;) {
            if (!((c[i] >= 65 && c[i] <= 90) 
                    || (c[i] >= 97 && c[i] <= 122))) {
                i++;
            } else if (!((c[j] >= 65 && c[j] <= 90) 
                    || (c[j] >= 97 && c[j] <= 122))) {
                j--;
            } else {
                char ch = c[i];
                c[i] = c[j];
                c[j] = ch;
                
                i++;
                j--;
            }
        }
        
        return new String(c);
    }
}