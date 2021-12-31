/*
1189. Maximum Number of Balloons
Easy

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int[] cs = new int[26];
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            cs[c - 'a']++;
        }
        
        int min = 10001;
                
        int a = 'a' - 'a';
        int b = 'b' - 'a';
        int l = 'l' - 'a';
        int o = 'o' - 'a';
        int n = 'n' - 'a';
        
        
        min = Math.min(min, cs[a]);
        min = Math.min(min, cs[b]);
        min = Math.min(min, cs[n]);
        min = Math.min(min, cs[l] / 2);
        min = Math.min(min, cs[o] / 2);
        
        
        return min == 100001? 0: min;
    }
}