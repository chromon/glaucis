/*
136. Single Number
Easy

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/

class Solution {
    public int singleNumber(int[] nums) {
        int t = 0; 
        
        // 异或：相同为 0，不同为 1
        // 与 0 异或为本身，与本身异或为 0
        for (int i = 0; i < nums.length; i++) {
            t ^= nums[i];
        }
        
        return t;
    }
}