/*
2099. Find Subsequence of Length K With the Largest Sum
Easy

You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
 

Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length
*/

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[][] valIdx = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            valIdx[i][1] = nums[i];
            valIdx[i][0] = i;
        }
        
        // 按照数值 nums[i] 从大到小排序
        Arrays.sort(valIdx, (a, b) -> b[1] - a[1]);
        // 按照索引 i 从小到大进行排列
        Arrays.sort(valIdx, 0, k, (a, b) -> a[0] - b[0]);
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = valIdx[i][1];
        }
        
        return res;
    }
}