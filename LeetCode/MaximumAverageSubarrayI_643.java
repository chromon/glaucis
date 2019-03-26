class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        
        int tmp = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            max = max > (nums[j] - tmp)? max: nums[j] - tmp;
            tmp = nums[i];
        }
        
        return (double) max / k;
    }
}