public class Solution {
    /**
     * @param A: A positive integer which has N digits, A is a string
     * @param k: Remove k digits
     * @return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        StringBuffer s = new StringBuffer(A);
        
        int i, j;
        for (i = 0; i < k; i++) {
            for (j = 0; j < s.length() - 1 && s.charAt(j) <= s.charAt(j + 1); j ++) {}
            s.deleteCharAt(j);
        }
        
        while (s.length() > 1 && s.charAt(0) == '0') {
            s.deleteCharAt(0);
        }
        
        return s.toString();
    }
}