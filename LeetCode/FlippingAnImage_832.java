class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = A[0].length - 1; j <= k; j++, k--) {
                int tmp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = tmp;
                
                if (j == k) {
                    if (A[i][j] == 1) {
                        A[i][j] = 0;
                    } else if (A[i][j] == 0) {
                        A[i][j] = 1;
                    }
                    break;
                }
                
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else if (A[i][j] == 0) {
                    A[i][j] = 1;
                }
                
                if (A[i][k] == 1) {
                    A[i][k] = 0;
                } else if (A[i][k] == 0) {
                    A[i][k] = 1;
                }
            }
        }
        
        return A;
    }
}