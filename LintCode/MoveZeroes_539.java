public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        // 把不等于 0 的移到前端，剩余位置置为 0
        
        int j = 0;
        for(int i = 0; i < nums.length ;) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                j ++;
            }
            i ++;
        }
        
        for(; j < nums.length; j ++) {
            nums[j] = 0;
        }
    }
}