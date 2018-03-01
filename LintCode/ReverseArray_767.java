public class Solution {
    /**
     * @param nums: a integer array
     * @return: nothing
     */
    public void reverseArray(int[] nums) {
        // write your code here
        
        for(int i = 0, j = nums.length - 1; i < j; i ++, j --) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}