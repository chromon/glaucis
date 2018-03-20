public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        
        // 动态规划
        // dp[i][j] = minVal(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        
        // 处理第一列每一行的边界数据
        for(int i = 1; i < m; i ++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // 处理第一行每一列的边界数据
        for(int j = 1; j < n; j ++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                dp[i][j] = minVal(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    public int minVal(int a, int b) {
        return a > b? b: a;
    }
}