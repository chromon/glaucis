public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        // Write your code here
        // 动态规划，同 604
        int[] dp = nums;
        
        if(dp.length == 0) {
            return 0;
        }
        
        for(int i = 1; i < dp.length; i ++) {
            dp[i] += dp[i - 1];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0, j = k - 1; j < dp.length; i ++, j ++) {
            int t = (i == 0)? dp[j]: dp[j] - dp[i - 1];
            max = t > max? t: max;
        }
        
        return (double) max / k;
    }
}