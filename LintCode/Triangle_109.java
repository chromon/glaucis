public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        
       for (int i = triangle.length - 2; i >= 0; i --) {
            for (int j = 0; j < triangle[i].length; j ++) {
                triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }
}