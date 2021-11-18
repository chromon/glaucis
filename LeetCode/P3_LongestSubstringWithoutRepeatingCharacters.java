/*
3. Longest Substring Without Repeating Characters
Medium

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

class Solution {

    public int lengthOfLongestSubstring(String s) {
        // 窗口中的相应字符的出现次数
        Map<Character, Integer> window = new HashMap<>();
        
        char[] sc = s.toCharArray();
        
        int left = 0, right = 0;
        
        int res = 0;
        while (right < sc.length) {
            // 将移入窗口的字符
            char c = sc[right];
            right++;
            
            // 更新窗口内数据
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                // 将移出窗口的字符
                char d = sc[left];
                left++;
                
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    /*
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.add(s.charAt(i));
            max = Math.max(max, queue.size());
        }
        return max;
    }
    */
}