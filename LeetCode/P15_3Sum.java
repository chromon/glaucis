/*
15. 3Sum
Medium

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/

class Solution {
    /*
        遍历排序后数组，对于每个元素 nums[i]：

        若 nums[i] > 0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
        
        对于重复元素：之前已经计算过，所以跳过，避免重复解。
        
        令左指针 L = i + 1，右指针 R = n − 1，当 L < R 时，执行循环：
        
            - 当 nums[i] + nums[L] + nums[R] == 0，执行循环，判断左界和右界是否和下一位置重复，
              去除重复解。并同时将 L, R 移到下一位置，寻找新的解。
            - 若和大于 0，说明 nums[R] 太大，R 左移。
            - 若和小于 0，说明 nums[L] 太小，L 右移。
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums.length < 3) {
            return res;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}