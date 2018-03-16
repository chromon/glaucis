public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        
        long lo = 1;
        long hi = x;
        
        while(lo + 1 < hi) {
            long mid = (hi - lo) / 2 + lo;
            
            if(mid * mid == x) {
                return (int) mid;
            } else if(mid * mid < x) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        if(hi * hi <= x) {
            return (int) hi;
        } else {
            return (int) lo;
        }
    }
}