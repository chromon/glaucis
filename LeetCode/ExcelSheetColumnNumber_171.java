class Solution {
    public int titleToNumber(String s) {
        
        // k进制数abcdef a*k^5+b*k^4+c*k^3+d*k^2+e*k^1+f*k^0
        char[] c = s.toCharArray();
        int res = 0;
        
        if (c.length == 0) {
            return 0;
        }
        
        for (int i = 0, j = c.length - 1; i < c.length; i++, j--) {
            int square = (int) Math.pow(26, i);
            res += ((int) c[j] - 64) * square;
        }
        
        return res;
    }
}