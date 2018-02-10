public class Solution {
    /**
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     */
    public boolean isPalindrome(int n) {
        // Write your code here
        
        String str = "";
        while(n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        
        char[] c = str.toCharArray();
        
        for(int i = 0, j = c.length - 1; i <= j; i ++, j --) {
            if(c[i] != c[j]) {
                return false;
            }
        }
        
        return true;
    }
}