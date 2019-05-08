class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] opt = new int[len];
        
        if (len <= 1) {
            return len == 0 ? 0 : nums[0];
        }
        
        opt[0] = nums[0];
        opt[1] = Math.max(nums[0], nums[1]);
        for (int i = 2 ; i < len ; i++) {
            opt[i] = Math.max(opt[i - 2] + nums[i], opt[i - 1]);
        }
        
        return opt[len - 1];
    }
}