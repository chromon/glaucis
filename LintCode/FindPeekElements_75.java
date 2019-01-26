public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int i = 1, j = A.length - 2;
        while (i <= j) {
            int m = (i + j) / 2;
            if (A[m - 1] < A[m] && A[m] > A[m + 1]) return m;
            if (A[m - 1] < A[m]) i = m + 1; else j = m - 1;
        }
        return i;
    }
}