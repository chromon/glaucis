/*
53. Maximum Subarray
Easy

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sum > max) {
                max = sum;
            }
            
            if (sum < 0) {
                sum = 0;
            } 
        }
        
        return max;
    }


    /*
        dp 数组的含义：

        以 nums[i] 为结尾的「最大子数组和」为 dp[i]

        根据 dp[i - 1] 得出 dp[i] 有两种「选择」，
        与前面的相邻子数组连接，形成一个和更大的子数组；不与前面的子数组连接，自成一派，自己作为一个子数组。
    */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}