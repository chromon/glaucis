/*
1512. Number of Good Pairs
Easy

Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

 

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

class Solution {
    /*
        1 - 2 - 3 - 4 - 5
        
        1 - 2
        1 - 3
        1 - 4
        1 - 5
        
        2 - 3
        2 - 4
        2 - 5
        
        3 - 4
        3 - 5
        
        4 - 5
        
        pairs = 4 + 3 + 2 + 1 
              = (n - 1) + (n - 2) + ... + 2 + 1
              = n * (n - 1) / 2
        
    */
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int sum = 0;
        for (int i: map.values()) {
            if (i >= 2) {
                sum += (i * (i - 1)) / 2;
            }
        }
        
        return sum;
    }
}