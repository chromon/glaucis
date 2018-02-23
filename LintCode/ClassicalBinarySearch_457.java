public class Solution {
    /*
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low + 1 < high) {
            int mid = (high - low) / 2 + low;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return -1;
    }
}