/*
1160. Find Words That Can Be Formed by Characters
Easy

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
words[i] and chars consist of lowercase English letters.
*/

class Solution {
    
    // 10 ms, faster than 57.50%
    public int countCharacters(String[] words, String chars) {
        int[] arr = new int[26];
        
        for (int i = 0; i < chars.length(); i++) {
            arr[chars.charAt(i) - 'a'] += 1;
        }
        
        int res = 0;
        
        for (int i = 0; i < words.length; i++) {
            int[] a = arr.clone();
            
            int j = 0;
            
            for (; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (a[c - 'a'] > 0) {
                    a[c - 'a']--;
                } else {
                    break;
                }
            }
            
            if (j == words[i].length()) {
                res += words[i].length();
            }
        }
        
        return res;
    }
    
    /*
    // 66 ms, faster than 11.34%
    public int countCharacters(String[] words, String chars) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
        }
        
        int res = 0;
        
        for (int i = 0; i< words.length; i++) {
            Map<Character, Integer> m = new HashMap<>(map);
            
            int j = 0;
            for (; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (m.containsKey(c) && m.get(c) > 0) {
                    m.put(c, m.get(c) - 1);
                } else {
                    break;
                }
            }
            
            if (j == words[i].length()) {
                res += words[i].length();
            }
        }
        
        return res;
    }
    */
}