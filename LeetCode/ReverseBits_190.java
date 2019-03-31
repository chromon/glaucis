public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int res = 0;
        int i = 32;
        
        while (i > 0) {
            res = res << 1;
            res += n & 1;
            n = n >> 1;
            i--;
        }
        
        return res;
    }
}