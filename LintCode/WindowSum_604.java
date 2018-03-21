public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        // 动态规划，同 943
        int[] dp = nums;
        
        if(dp.length == 0) {
            return dp;
        }
        
        for(int i = 1; i < dp.length; i ++) {
            dp[i] += dp[i - 1];
        }
        
        int[] r = new int[dp.length - k + 1];
        for(int i = 0, j = k - 1; j < dp.length; i ++, j ++) {
            r[i] = i == 0? dp[j]: dp[j] - dp[i - 1];
        }
        
        return r;
    }
}