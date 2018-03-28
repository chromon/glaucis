public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        // 动态规划: 计算出走到每一个点有多少途径
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        // 处理第一列每一行的边界数据
        for(int i = 0; i < m; i ++) {
            if(obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        
        // 处理第一行每一列的边界数据
        for(int j = 0; j < n; j ++) {
            if(obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }
        
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                if(obstacleGrid[i][j] == 0) {
                    // 从起点走到该点有几种途径等于从起点到
                    // 该点上面的点和该点左边的点途径之和 
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}