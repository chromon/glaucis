public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        
        int i = 0;
        int j = nums.length - 1;
        
        if(nums.length == 0) {
            return 0;
        }
        
        while (i <= j) {
            while (i <= j && nums[i] < k) {
                i ++;
            }
            
            while (i <= j && nums[j] >= k) {
                j --;
            }
            
            if (i <= j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                
                i ++;
                j --;
            }
        }
        
        return i;
    }
}