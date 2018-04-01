public class Solution {
    /**
     * @param n: the number n 
     * @return: the times n convert to 1
     */
    public int digitConvert(int n) {
        // Write your code here 
        int count = 0;
        
        while(n != 1) {
            if(n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
            
            count ++;
        }
        
        return count;
    }
}