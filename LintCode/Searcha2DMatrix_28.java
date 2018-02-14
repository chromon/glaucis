public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int r = matrix.length;
        
        if(r == 0) {
            return false;
        }
        
        int c = matrix[0].length;
        
        int i;
        for(i = 0; i < r; i ++) {
            if(matrix[i][c - 1] > target) {
                break;
            } else if(matrix[i][c - 1] == target) {
                return true;
            }
        }
        
        if(i == r) {
            if(matrix[i - 1][c - 1] == target) {
                return true;
            }
            return false;
        }
        
        for(int j = 0; j < c; j ++) {
            if(matrix[i][j] == target) {
                return true;
            }
        }
        
        return false;
    }
}