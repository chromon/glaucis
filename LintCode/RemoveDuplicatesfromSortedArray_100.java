public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        // 遍历一次数组，将不重复元素保留，重复元素被覆盖
        
        if(nums.length == 0) {
            return 0;
        }
        
        int t = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != nums[t]) {
                t ++;
                nums[t] = nums[i];
            }
        }
        
        return t + 1;
    }
}