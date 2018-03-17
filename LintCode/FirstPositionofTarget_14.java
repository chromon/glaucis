public class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (hi + lo) / 2;
        
        while(lo < hi) {
            
            if(nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
            
            mid = (hi + lo) / 2;
        }
        
        if(nums[mid] == target) {
            return mid;
        }
        
        return -1;
    }
}