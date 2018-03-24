public class Solution {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        String s = num + "";
        
        for(int i = 0, j = s.length() - 1; i < j; i ++, j --) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
}