public class Solution {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        
        String s = Math.abs(n) + "";
        
        char[] c = s.toCharArray();
        
        StringBuffer sb = new StringBuffer();
        for(int i = c.length - 1; i >= 0; i --) {
            sb.append(c[i]);
        }
        
        int t = 0;
        
        if(-2147483648 < Long.parseLong(sb.toString()) 
            && Long.parseLong(sb.toString()) < 2147483647) {
            
            t = Integer.parseInt(sb.toString());
            if(n < 0) {
                t = -t;
            }
            return t;
        }
        
        return 0;
    }
}