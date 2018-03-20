public class Solution {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int t = 0;
        
        for(int i = 0; i < A.length; i ++) {
            if(A[i] != elem) {
                A[t ++] = A[i];
            }
        }
        
        // remove last (A.length - t) element from A
        
        return t;
    }
}