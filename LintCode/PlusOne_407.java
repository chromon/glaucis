public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        int tmp = 0;
        int t = 1;
        
        for(int i = digits.length - 1; i >= 0; i --) {
            int k = digits[i] + tmp + t;
            if(k >= 10) {
                digits[i] = k % 10;
                tmp = 1;
                t = 0;
            } else {
                digits[i] = k;
                tmp = 0;
                break;
            }
        }
        
        if(tmp > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            
            for(int i = 1; i < digits.length + 1; i ++) {
                result[i] = digits[i - 1];
            }
            
            return result;
        }
        
        return digits;
    }
}