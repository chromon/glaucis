class Solution {
    public String addStrings(String num1, String num2) {
        
        int carry = 0;
        String res = "";
        
        int i = num1.length() - 1;     
        int j = num2.length() - 1;
        
        for (; i >= 0 || j >= 0; i--, j--) {
            int a;
            int b;
            int tmp = 0;
            
            if (i >= 0) {
                a = (int)(num1.charAt(i) - '0');
                tmp += a;
            }
            
            if (j >= 0) {
                b = (int)(num2.charAt(j) - '0');
                tmp += b;
            }
            
            tmp += carry;
            
            if (tmp > 9) {
                carry = 1;
                tmp %= 10;
                res = tmp + res;
            } else {
                carry = 0;
                res = tmp + res;
            }
        }
        
        if (carry > 0) {
            res = carry + res;
        }
        
        return res;
    }
}