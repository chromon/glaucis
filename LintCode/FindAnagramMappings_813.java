public class Solution {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] A, int[] B) {
        // Write your code here
        
        int[] p = new int[A.length];
        
        for(int i = 0; i < A.length; i ++) {
            for(int j = 0; j < B.length; j ++) {
                if(A[i] == B[j]) {
                    p[i] = j;
                }
            }
        }
        
        return p;
    }
}