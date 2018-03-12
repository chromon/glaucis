public class Solution {
    /**
     * @param s: a string
     * @return: nothing
     */
     
    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        
        for(int i = 0, j = c.length - 1; i < j; i ++, j --) {
            if(c[i] != c[j]) {
                return isPalindrome(c, i + 1, j) || isPalindrome(c, i, j - 1);
            }
        }
        
        return true;
    }
    
    public boolean isPalindrome(char[] c, int i, int j) {
        
        for(;i < j; i ++, j --) {
            if(c[i] != c[j]) {
                return false;
            }
        }
        
        return true;
    }
    
    /*
    public boolean validPalindrome(String s) {
        // Write your code here
        
        for(int t = -1; t < s.length(); t ++) {
            if(isPalindrome(t, s)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isPalindrome(int t, String s) {
        char[] c = s.toCharArray();
        
        for(int i = 0, j = c.length - 1; i < j;) {
            if(i == t) {
                i ++;
            } else if(j == t) {
                j --;
            }
            
            if(c[i] != c[j]) {
                return false;
            }
            
            i ++;
            j --;
        }
        
        return true;
    }
    */
}