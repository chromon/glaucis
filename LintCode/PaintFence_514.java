public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        
        /*
            思路 = 动态规划
            第一个柱子的染色方案有：dp[1] = k
            第二个柱子的染色方案有：dp[2] = k * k
            第三个柱子的染色方案：
                如果第三个柱子和第二个柱子颜色相同，那么第一个柱子肯定与二，三颜色不同，
                则染色方案有dp[1] * (k - 1)；
                如果第三个柱子和第二个柱子颜色不同，则与第一个柱子颜色无关，
                则染色方案有dp[2] * (k - 1)；
                
            第n个柱子的染色方案
                如果第n个柱子和第n-1个柱子颜色相同，那么第n-2个柱子肯定与n-1，n颜色不同，
                则染色方案有dp[n-2] * (k - 1)；
                如果第n个柱子和第n-1个柱子颜色不同，则与第n-2个柱子颜色无关，
                则染色方案有dp[n-1] * (k - 1)；
                
            由以上可以得出状态转移方程：dp[n] = (dp[n - 1] + dp[n - 2]) * (k - 1)
        */
        
        if(n == 1) {
            return k;
        } else if(n == 2) {
            return k * k;
        }
        
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        
        for(int i = 2; i < n; i ++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }
        
        return dp[n - 1];
    }
}