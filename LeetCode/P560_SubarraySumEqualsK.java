/*
560. Subarray Sum Equals K
Medium

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/

class Solution {
    /*
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        
        int res = 0;
        
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 0; j < preSum.length; j++) {
                if (preSum[i] - preSum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }
    */
    
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // map 前缀和，该前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);

        int res = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                res += preSum.get(sum0_j);
            }
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}