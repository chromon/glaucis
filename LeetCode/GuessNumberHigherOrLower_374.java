/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        int mi = lo;
        
        while (lo <= hi) {
            mi = lo + (hi - lo) / 2;
            
            int t = guess(mi);
            
            if (t == 0) {
                return mi;
            } else if (t == 1) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        
        return mi;
    }
}