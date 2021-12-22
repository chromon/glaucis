/*
884. Uncommon Words from Two Sentences
Easy

A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

 

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
 

Constraints:

1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.
*/

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        Map<String, Integer> map = new HashMap<>();
        String[] w1 = s1.split(" ");
        String[] w2 = s2.split(" ");
        
        for (int i = 0; i < w1.length; i++) {
            map.put(w1[i], map.getOrDefault(w1[i], 0) + 1);
        }
        
        for (int i = 0; i < w2.length; i++) {
            map.put(w2[i], map.getOrDefault(w2[i], 0) + 1);
        }
        
        List<String> res = new ArrayList<>();
        for (String w: map.keySet()) {
            if (map.get(w) == 1) {
                res.add(w);
            }
        }
        
        return res.toArray(new String[res.size()]);
    }
}