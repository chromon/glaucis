/*
567. Permutation in String
Medium

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/

class Solution {
    // s2 中是否存在一个子串，包含 s1 中所有字符且不包含其他字符
    public boolean checkInclusion(String s1, String s2) {
        // 记录 s2 中字符出现次数
        Map<Character, Integer> need = new HashMap<>();
        // 窗口中的相应字符的出现次数
        Map<Character, Integer> window = new HashMap<>();
        
        // s2 为主串，s1 是目标字符串
        char[] sc = s2.toCharArray();
        char[] tc = s1.toCharArray();
        
        for (char c: tc) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0;
        // 窗口中满足 need 条件的字符个数
        int valid = 0;
        
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
            while (right - left == tc.length) {
                // 是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
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
        return false;
    }
}