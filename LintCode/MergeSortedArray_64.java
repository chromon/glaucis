public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        // 倒叙追加
        
        int i = m - 1;
        int j = n - 1;
        int t = 0;
        int length = m + n - 1;
        
        for(t = length; t >= 0 && i >= 0 && j >= 0; t --) {
            if(A[i] >= B[j]) {
                A[t] = A[i];
                i --;
            } else {
                A[t] = B[j];
                j --;
            }
        }
        
        // A遍历完，B没遍历完，即（i < 0, j >= 0），B顺序追加到A头部
        // 反过来时不变
        while(j >= 0) {
            A[t] = B[j];
            t --;
            j --;
        }
    }
}