public class Solution {
    /**
     * @param matrix: an input matrix 
     * @return: nums[0]: the maximum,nums[1]: the minimum
     */
    public int[] maxAndMin(int[][] matrix) {
        // write your code here
        if(matrix != null && matrix.length == 0) {
            return new int[0];
        }
        
        int max = matrix[0][0];
        int min = matrix[0][0];
        
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix.length; j ++) {
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                }
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        
        int[] r = new int[2];
        r[0] = max;
        r[1] = min;
        return r;
    }
}