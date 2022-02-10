/*
45. Jump Game II
Medium

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
*/

class Solution {
    // 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置
    public int jump(int[] nums) {
        
        // 目前能跳到的最远位置
        int maxFar = 0;
        // 跳跃次数
        int jump = 0;
        // 上次跳跃可达范围右边界（下次的最右起跳点）
        int end = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            maxFar = Math.max(maxFar, i + nums[i]);
            if (end == i) {
                end = maxFar;
                jump++;
            }
        }
        
        return jump;
    }
}