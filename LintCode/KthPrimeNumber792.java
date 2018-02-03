public class Solution {
    
    public boolean isPrime(int n) {
        
        for(int i = 2; i <= Math.sqrt(n); i ++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * @param n: the number
     * @return: the rank of the number
     */
    public int kthPrime(int n) {
        // write your code here
        
        int[] a = new int[n];
        int c = 0;
        for(int i = 2; i <= n; i ++) {
            if(isPrime(i)) {
                c ++;
            }
        }
        return c;
    }
}