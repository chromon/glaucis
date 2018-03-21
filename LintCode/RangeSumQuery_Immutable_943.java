public class NumArray {
    /**
     * @return: nothing
     * 
     * 动态规划建立累计直方图的思想来建立一个累计和的数组dp，
     * 其中dp[i]表示[0, i]区间的数字之和，那么[i,j]就可以表示为dp[j]-dp[i-1]，
     * 这里要注意一下当i=0时，直接返回dp[j]
     */
    private int[] dp;
     
    public NumArray(int[] nums){
        dp = nums;
        for(int i = 1; i < dp.length; i ++) {
            dp[i] += dp[i - 1]; 
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0? dp[j]: dp[j] - dp[i - 1];
    }
}