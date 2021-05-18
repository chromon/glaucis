/*
290. Word Pattern
Easy

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 
Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", s = "dog dog dog dog"
Output: false
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] strs = s.split(" ");
        char[] c = pattern.toCharArray();
        
        if (c.length != strs.length) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(c[i])) {
                if (!map.get(c[i]).equals(strs[i])) {
                    return false;
                } 
            } else if (map.containsValue(strs[i])) {
                return false;
            } 
            map.put(c[i], strs[i]);
        }
            
        return true;
    }
}