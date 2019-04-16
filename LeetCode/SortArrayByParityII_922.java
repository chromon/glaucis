class Solution {
    public int[] sortArrayByParityII(int[] A) {
        
        int[] res = new int[A.length];
        int m = 0, n = 1;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[m] = A[i];
                m += 2;
            } else {
                res[n] = A[i];
                n += 2;
            }
        }
        
        return res;
    }
}