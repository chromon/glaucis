/*
1770. Maximum Score from Performing Multiplication Operations
Medium

You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.

 

Example 1:

Input: nums = [1,2,3], multipliers = [3,2,1]
Output: 14
Explanation: An optimal solution is as follows:
- Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
- Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
- Choose from the end, [1], adding 1 * 1 = 1 to the score.
The total score is 9 + 4 + 1 = 14.
Example 2:

Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
Output: 102
Explanation: An optimal solution is as follows:
- Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
- Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
- Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
- Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
- Choose from the end, [-2,7], adding 7 * 6 = 42 to the score. 
The total score is 50 + 15 - 9 + 4 + 42 = 102.
 

Constraints:

n == nums.length
m == multipliers.length
1 <= m <= 103
m <= n <= 105
-1000 <= nums[i], multipliers[i] <= 1000
*/

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        // 使用 dp[i][j] 表示从 nums 的左边选取了 i 个元素，右边选取了 j 个元素
        // 0 <= i, j <= m
        // 每一个新的状态 dp[i][j] 都可以从两个旧状态 dp[i-1][j] 和 dp[i][j-1] 得到。
        
        // int idx = i + j - 1; // 表示从 multipiers 中选取的元素的下标
        // dp[i][j] = Math.max(dp[i-1][j] + nums[i-1]*multi[idx], dp[i][j-1] + nums[n-i]*multi[idx]);

        // 最终结果应该从 dp[x][y] 中得到，其中需要满足 x + y == m。
        
        int n = nums.length;
        int m = multipliers.length;
        
        int[][] dp = new int[m + 1][m + 1];
        
        // 计算只从左边取或者只从右边取的情况，避免后面的越界判断
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] + nums[n - i] * multipliers[i - 1];
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * multipliers[i - 1];
        }
        
        // 状态计算
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m - i; j++) {
                int idx = i + j - 1;
                dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1] * multipliers[idx], 
                                    dp[i][j - 1] + nums[n - j] * multipliers[idx]);
            }
        }
        
        // 获取最终结果
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i][m - i]);
        }
        
        return ans;
    }
}