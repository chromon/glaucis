class Solution {
    public int maximumProduct(int[] nums) {
        
        /*
            三个最大正数直接乘起来最大，
            两个最小的负数乘起来再乘以一个最大的正数
        */
        
        Arrays.sort(nums);
        
        int len = nums.length;
        
        int max1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int max2 = nums[0] * nums[1] * nums[len -1];
        
        return max1 > max2? max1: max2;
    }
}