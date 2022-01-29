/*
16. 3Sum Closest
Medium

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/

class Solution {
    
    /*
        与 15.3Sum 基本相同。
        
        sum = a + b + c
        
        借助双指针，用 left 和 right 分别表示指向 b 和 c 的指针，初始时，left 指向位置 i+1，
        即左边界；right 指向位置 n − 1，即右边界。
        
        在每一步枚举的过程中，用 a + b + c 来更新答案，并且：
            - 如果 a + b + c == target，return target.
            - 如果 a + b + c > target，将 right 向左移动一个位置；
            - 如果 a + b + c < target，将 left 向右移动一个位置。
            
        可以使用去重优化。
    */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int min = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length; i++) {
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } 
                
                if (Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                }
                
                if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return min;
    }
}