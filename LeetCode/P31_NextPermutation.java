/*
31. Next Permutation
Medium

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
*/

class Solution {
    /*
        1. 需要将一个左边的「较小数」与一个右边的「较大数」交换，
           以能够让当前排列变大，从而得到下一个排列。

        2. 同时要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数
           需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。

        对于长度为 n 的排列 a：

        1. 首先从后向前查找第一个顺序对 (i, i + 1)，满足 a[i] < a[i + 1]。这样「较小数」即为   
           a[i]。此时 [i + 1, n) 必然是下降序列。

        2. 如果找到了顺序对，那么在区间 [i + 1, n) 中从后向前查找第一个元素 j 满足 a[i] < a[j]。
           这样「较大数」即为 a[j]。

        3. 交换 a[i] 与 a[j]，此时可以证明区间 [i + 1, n) 必为降序。可以直接使用双指针反转区间 
           [i + 1, n) 使其变为升序，而无需对该区间进行排序。
           
        4. 如果在步骤 1 找不到顺序对，说明当前序列已经是一个降序序列，即最大的序列，
           直接跳过步骤 2 执行步骤 3，即可得到最小的升序序列。 
    */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int start) {
        for (int i = start, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
}