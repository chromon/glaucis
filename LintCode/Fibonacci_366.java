public class Solution {
    /*
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        
        int s1 = 0;
        if(n == 0 || n == 1) {
            return s1;
        }
        
        int s2 = 1;
        if(n == 2) {
            return s2;
        }
        // return fibonacci(n - 1) + fibonacci(n - 2);
        
        int s = 0;
        for(int i = 2; i < n; i++) {
            s = s1 + s2;
            s1 = s2;
            s2 = s;
        }
        
        return s;
    }
}