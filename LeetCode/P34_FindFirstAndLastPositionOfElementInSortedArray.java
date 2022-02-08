/*
34. Find First and Last Position of Element in Sorted Array
Medium

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/

class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target - 1);
        int j = binarySearch(nums, target) - 1;
        if (i <= j && nums[i] == target) {
            return new int[]{i, j};
        }
        
        return new int[]{-1, -1};
    }
    
    // 第一个大于 target 的数的下标
    private int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums.length;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    
    /*
    public int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target);
        if (i >= nums.length || nums[i] != target) {
            return new int[]{-1, -1};
        }
        
        int j = binarySearch(nums, target + 1);
        
        return new int[]{i, j - 1};
    }
    
    // 寻找第一个大于等于 target 的索引，没有则返回数组长度 
    private int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    */
}