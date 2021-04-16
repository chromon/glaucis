/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/

class Solution {
    public boolean isAnagram(String s, String t) {
    
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] alph = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alph[c - 'a'] ++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            alph[c - 'a'] --;
        }
        
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    
    /*
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        
        if (s == "" && t == "") {
            return true;
        }        
        
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                map.put(c[i], map.get(c[i]) + 1);
            } else {
                map.put(c[i], 1);
            }
        }
        
        char[] c2 = t.toCharArray();
        
        for (int i = 0; i < c2.length; i++) {
            if (map.containsKey(c2[i])) {
                map.put(c2[i], map.get(c2[i]) - 1);
            } else {
                return false;
            }
        }
        
        for(int v : map.values()){
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
    */
}