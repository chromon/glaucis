public class Solution {
    /**
     * @param A: An integer array
     * @param B: An integer array
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int ai = 0, bi = 0;
        int min = Integer.MAX_VALUE;
        while (ai < A.length && bi < B.length) {
            min = Math.min(min, Math.abs(A[ai] - B[bi]));
            if (A[ai] < B[bi]) {
                ai++;
            } else {
                bi++;
            }
        }
        return min;
    }
}