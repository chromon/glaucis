class Solution {
    public int[] sortedSquares(int[] A) {
        
        int[] res = new int[A.length];
        
        int i = 0;
        while (i < A.length && A[i] < 0) {
            i++;
        }
        int j = i - 1;
        
        int k = 0;
        while (j >= 0 && i < A.length) {
            if (A[i] * A[i] < A[j] * A[j]) {
                res[k++] = A[i] * A[i];
                i++;
            } else {
                res[k++] = A[j] * A[j];
                j--;
            }
        }
        
        while (j >= 0) {
            res[k++] = A[j] * A[j];
            j--;
        }
        
        while (i < A.length) {
            res[k++] = A[i] * A[i];
            i++;
        }
        
        return res;
    }
}