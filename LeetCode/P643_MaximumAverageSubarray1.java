/*
643. Maximum Average Subarray I
Easy

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 

Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
*/

class Solution {
    
    /*
    // Time Limit Exceeded
    public double findMaxAverage(int[] nums, int k) {
        
        double max = Integer.MIN_VALUE;
        
        for (int i = 0; i <= nums.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            sum /= k;
            max = sum > max? sum: max;
        }
        return max;
    }
    */
    
    public double findMaxAverage(int[] nums, int k) {
        double[] sum = new double[nums.length];
        sum[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        double res = sum[k - 1] / k;
        for (int i = k; i < sum.length; i++) {
            res = Math.max(res, (sum[i] - sum[i - k]) / k);
        }
        
        return res;
    }
}