public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        
        int i = 0, j = nums.length - 1;
        
        while(i < j) {
            
            if(nums[i] % 2 == 0 && nums[j] % 2 != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            
            if(nums[i] % 2 != 0) {
                i ++;
            }
            
            if(nums[j] % 2 == 0) {
                j --;
            }
        }
    }
}