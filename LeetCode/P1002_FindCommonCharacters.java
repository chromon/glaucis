/*
1002. Find Common Characters
Easy

Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
*/

class Solution {
    public List<String> commonChars(String[] words) {
        
        List<String> res = new ArrayList<>();
        int[] charSet = new int[26];
        Arrays.fill(charSet, Integer.MAX_VALUE);
        
        for (String w: words) {
            int[] tmpSet = new int[26];
            
            for (char c: w.toCharArray()) {
                tmpSet[c - 'a']++;
            }
            
            for (int i = 0; i <charSet.length; i++) {
                charSet[i] = Math.min(charSet[i], tmpSet[i]);
            }
        }
        
        for (int i = 0; i < 26; i++) {
            while (charSet[i] != 0) {
                res.add(String.valueOf((char) (i + 'a')));
                charSet[i]--;
            }
        }
        return res;
    }
}