public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: Cosine similarity
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        
        int dividend = 0;
        
        double divisor = 1;
        
        double a2 = 0;
        double b2 = 0;
        
        for (int i = 0; i < A.length; i ++) {
            dividend += A[i] * B[i];
            a2 += A[i] * A[i];
            b2 += B[i] * B[i];
        }
        
        divisor = Math.sqrt(a2) * Math.sqrt(b2);
        
        if(divisor == 0) {
            return 2.0000;
        }
        
        double result = dividend / divisor;
        
        return result;
    }
}