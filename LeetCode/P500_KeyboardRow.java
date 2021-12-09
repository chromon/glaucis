/*
500. Keyboard Row
Easy

Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

 

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Example 2:

Input: words = ["omk"]
Output: []
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 

Constraints:

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 
*/

class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        
        for (int i = 0; i < words.length; i++) {
            if (contains(words[i], s1) || contains(words[i], s2) 
                    || contains(words[i], s3)) {
                res.add(words[i]);
            }
        }
        
        return res.toArray(new String[res.size()]);
    }
    
    private boolean contains(String word, String keyboard) {
        for (int i = 0; i < word.length(); i++) {
            if (!keyboard.contains(String.valueOf(word.charAt(i)))) {
                return false;
            }
        }
                
        return true;
    }
}