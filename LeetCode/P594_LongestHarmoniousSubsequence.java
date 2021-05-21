/*
594. Longest Harmonious Subsequence
Easy

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Example 2:

Input: nums = [1,2,3,4]
Output: 2
Example 3:

Input: nums = [1,1,1,1]
Output: 0
 

Constraints:

1 <= nums.length <= 2 * 104
-109 <= nums[i] <= 109
*/

/*
可以把和谐子序列抽象成一个只存在相邻两个数字的数组，位置无所谓的。

那么，先数每个数字出现的次数，然后对每个数字num，找num+1是否存在，如果存在就记录两个和的最大值。
*/
class Solution {
    public int findLHS(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int count = 0;
        
        for (int i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                count = Math.max(count, map.get(i) + map.get(i + 1));
            }
        }
        
        return count;
    }
}