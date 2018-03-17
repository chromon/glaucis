public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        
        int len = A.length + B.length;
        int[] c = new int[len];
        
        int i = 0;
        int j = 0;
        
        for(int k = 0; k < len; k ++) {
            if(i < A.length && j < B.length) {
                if(A[i] <= B[j]) {
                    c[k] = A[i];
                    i ++;
                } else {
                    c[k] = B[j];
                    j ++;
                }
            } else {
                if(i < A.length) {
                    c[k] = A[i];
                    i ++;
                }
                
                if(j < B.length) {
                    c[k] = B[j];
                    j ++;
                }
            }
        }
        
        return c;
    }
}