/*
219. Contains Duplicate II
Easy

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/

// map.put() Returns:
// the previous value associated with key, or null if there was no mapping for key.
// (A null return can also indicate that the map previously associated null with key.)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
        for(int i = 0; i <  nums.length; i++) {
            Integer ord = map.put(nums[i], i);
            if(ord != null && i - ord <= k) {
                return true;
            }
        }

        return false;
    }
}