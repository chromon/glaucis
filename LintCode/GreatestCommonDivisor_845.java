public class Solution {
    /**
     * @param a: the given number
     * @param b: another number
     * @return: the greatest common divisor of two numbers
     */
    public int gcd(int a, int b) {
        // write your code here
        
        while(b != 0) {
            int r = b;
            b = a % b;
            a = r;
        }
            
        return a;
    }
}