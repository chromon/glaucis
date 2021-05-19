/*
345. Reverse Vowels of a String
Easy

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.


Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
*/

class Solution {
    public String reverseVowels(String s) {
        
        char[] c = s.toCharArray();
        Character[] v = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = Set.of(v);
        
        for (int i = 0, j = c.length - 1; i < j;) {
            
            if (!set.contains(c[i])) {
                i++;
                continue;
            }
            
            if (!set.contains(c[j])) {
                j--;
                continue;
            }
            
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
        
        return new String(c);
    }
}