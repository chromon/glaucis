/*
1592. Rearrange Spaces Between Words
Easy

You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

 

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
 

Constraints:

1 <= text.length <= 100
text consists of lowercase English letters and ' '.
text contains at least one word.
*/

class Solution {
    public String reorderSpaces(String text) {
        
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        
        String[] w = text.trim().split("\\s+");
        int space = 0;
        int left = 0;
        
        if (w.length < 2) {
            left = count;
        } else {
            space = count / (w.length - 1);
            left = count % (w.length - 1);
        }
        
        StringBuilder ssb = new StringBuilder();
        StringBuilder lsb = new StringBuilder();
        for (int i = 0; i < space; i++) {
            ssb.append(" ");
            // if (i < left) {
            //     lsb.append(" ");
            // }
        }
        
        for (int i = 0; i < left; i++) {
            lsb.append(" ");
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < w.length; i++) {
            sb.append(w[i]);
            if (i < w.length - 1) {
                sb.append(ssb);
            }
        }
        sb.append(lsb);
        
        return sb.toString();
    }
}