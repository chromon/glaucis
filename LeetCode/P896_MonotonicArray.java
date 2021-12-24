/*
896. Monotonic Array
Easy

An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

 

Example 1:

Input: nums = [1,2,2,3]
Output: true
Example 2:

Input: nums = [6,5,4,4]
Output: true
Example 3:

Input: nums = [1,3,2]
Output: false
 

Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105
*/

class Solution {
    public boolean isMonotonic(int[] nums) {
        
        if (nums.length == 1) {
            return true;
        }
        
        boolean asc = true;
        boolean desc = true;
        int t = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (t > nums[i]) {
                asc = false;
                break;
            }
            t = nums[i];
        }
        
        t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (t < nums[i]) {
                desc = false;
                break;
            }
            t = nums[i];
        }
        
        return asc || desc;
    }
}