/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        int res = n;
        
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!isBadVersion(mi)) {
                lo = mi + 1; 
            } else {
                hi = mi;
            }
        }
        
        return lo;
    }
}