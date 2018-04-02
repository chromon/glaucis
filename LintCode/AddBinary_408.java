public class Solution {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        
        int t = 0;
        String s = "";
        
        int i = ca.length - 1;
        int j = cb.length - 1;
        
        while(i >= 0 || j >= 0) {
            
            int cai = 0;
            int cbi = 0;
            
            if(i >= 0) {
                cai = Integer.parseInt(String.valueOf(ca[i]));
            } else {
                cai = 0;
            }
            
            if(j >= 0) {
                cbi = Integer.parseInt(String.valueOf(cb[j]));
            } else {
                cbi = 0;
            }
            
            int ci = cai + cbi + t;
            t = 0;
            
            if(ci == 2) {
                ci = 0;
                t = 1;
            } else if(ci == 3) {
                ci = 1;
                t = 1;
            }
            
            s = ci + s;
            
            i --;
            j --;
        }
        
        if(t > 0) {
            s = t + s;
        }
        
        return s;
    }
}