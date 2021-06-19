/*
128. Longest Consecutive Sequence
Medium

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
Accepted
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        int max = 1;
        
        for (int n : nums) {
            set.add(n);
        }
        
        for (int n : nums) {
            if (set.contains(n - 1)) {
                continue;
            }
            
            int start = n;
            while (set.contains(start + 1)) {
                start++;
            }
            max = Math.max(max, start - n + 1);
        }
        return max;
    }
}