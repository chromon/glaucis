/*
438. Find All Anagrams in a String
Medium

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/

class Solution {
    // 输入一个串 S，一个串 P，找到 S 中所有 P 的排列，返回它们的起始索引
    public List<Integer> findAnagrams(String s, String p) {
        // 记录 p 中字符出现次数
        Map<Character, Integer> need = new HashMap<>();
        // 窗口中的相应字符的出现次数
        Map<Character, Integer> window = new HashMap<>();
        
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        
        for (char c: pc) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        // 窗口中满足 need 条件的字符个数
        int valid = 0;
        
        // 记录起始索引
        List<Integer> res = new ArrayList<>();
        while (right < sc.length) {
            // 将移入窗口的字符
            char c = sc[right];
            right++;
            
            // 更新窗口内数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            // 判断左侧窗口是否要收缩
            while (right - left == pc.length) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.add(left);
                }
                
                // 将移出窗口的字符
                char d = sc[left];
                left++;
                
                // 更新窗口内数据
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }
}