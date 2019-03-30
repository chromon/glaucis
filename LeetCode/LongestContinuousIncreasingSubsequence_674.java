class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        
        int pre = nums[0];
        int max = 1, count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                count++;
            } else {
                count = 1;
            }
            
            if (count > max) {
                max = count;
            }
            
            pre = nums[i];
        }
        
        return max;
    }
}