public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        
        String str = s.replaceAll("[\\p{Punct}\\p{Space}]+", "").toLowerCase();
        
        char[] c = str.toCharArray();
        
        for(int i = 0, j = c.length - 1; i < j; i ++, j --) {
            if(c[i] != c[j]) {
                return false;
            }
        }
        
        return true;
    }
}