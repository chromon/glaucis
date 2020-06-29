class Solution {
    public String addBinary(String a, String b) {
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carry = 0;
        String s = "";
        
        while (i >= 0 || j >= 0) {
            
            int ai = 0;
            int bj = 0 ;
            
            if (i >= 0) {
                ai = Integer.parseInt(String.valueOf(a.charAt(i)));
            } else {
                ai = 0;
            }
            
            if (j >= 0) {
                bj = Integer.parseInt(String.valueOf(b.charAt(j)));
            } else {
                bj = 0;
            }
            
            int t = ai + bj + carry;
            carry = 0;
            
            if (t == 2) {
                t = 0;
                carry = 1;
            } else if (t == 3) {
                t = 1;
                carry = 1;
            }
            
            s = t + s;
            
            i--;
            j--;
        }
        
        if (carry > 0) {
            s = carry + s;
        }
        
        return s;
    }
}