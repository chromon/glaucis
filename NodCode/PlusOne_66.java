class Solution {
    public int[] plusOne(int[] digits) {
        
        int flag = 0;
        int addend = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + flag + addend;
            addend = 0;
            
            if (tmp > 9) {
                flag = 1;
                digits[i] = tmp - 10;
            } else {
                flag = 0;
                digits[i] = tmp;
            }
        }
        
        if (flag > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = flag;
            
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            
            return res;
        }
        
        return digits;
    }
}