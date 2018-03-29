/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
    int guess(int num); 
*/

public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        
        int lo = 1; 
        int hi = n;
        
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int result = guess(mid);
            
            if(result == 1) {
                lo = mid + 1;
            } else if(result == -1) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}