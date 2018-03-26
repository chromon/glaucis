public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        
        if(A.length == 0) {
            return 0;
        }
        
        int[] inc = new int[A.length];
        int[] dec = new int[A.length];
        
        inc[0] = 1;
        dec[0] = 1;
        
        for(int i = 1; i < A.length; i ++) {
            if(A[i] > A[i - 1]) {
                inc[i] = inc[i - 1] + 1;
                dec[i] = 1;
            } else {
                dec[i] = dec[i - 1] + 1;
                inc[i] = 1;
            }
        }
        
        int m1 = arrayMax(inc);
        int m2 = arrayMax(dec);
        
        return m1 > m2? m1: m2;
    }
    
    public int arrayMax(int[] a) {
        int t = a[0];
        
        for(int i = 1; i < a.length; i ++) {
            if(a[i] > t) {
                t = a[i];
            }
        }
        
        return t;
    }
}