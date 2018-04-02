public class Solution {
    /**
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] result = new int[m * n];
        
        if(m == 0) {
            return result;
        }
        
        // 是否向上
        boolean up = true;
        int i = 0, j = 0, t = 0;
        
         while(t < m * n) {
            
            up = true;
            
            while(up && i >= 0 && j < n) {
                result[t] = matrix[i][j];
                i -= 1;
                j += 1;
                t ++;
            }
            
            if(j < n) {
                // 向右
                i += 1;
            } else {
                // 向下
                i += 2;
                j -= 1;
            }
            
            up = false;
            
            while(! up && i < m && j >= 0) {
                result[t] = matrix[i][j];
                i += 1;
                j -= 1;
                t ++;
            }
            
            if(i < m) {
                // 向下
                j += 1;
            } else {
                // 向右
                j += 2;
                i -= 1;
            }
        }
        
        return result;
    }
}