/*
645. Set Mismatch
Easy

You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
*/

class Solution {
    /*
    public int[] findErrorNums(int[] nums) {
        
        Arrays.sort(nums);
        
        int dup = 0;
        int los = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                los = nums[i - 1] + 1;
            }
        }
        
        los = nums[nums.length - 1] != nums.length? nums.length: los;
        return new int[]{dup, los};
    }
    */
    
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = 0;
        int los = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                dup = nums[i];
            }
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                los = i;
            }
        }
        
        return new int[]{dup, los};
    }

}