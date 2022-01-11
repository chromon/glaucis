/*
1636. Sort Array by Increasing Frequency
Easy

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

 

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
*/

class Solution {
    /*
    public int[] frequencySort(int[] nums) {
       
        int[] freq = new int[201];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i] + 100]++;
        }
        
        NumFreq[] nf = new NumFreq[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nf[i] = new NumFreq(nums[i], freq[nums[i] + 100]);
        }
        
        Arrays.sort(nf, new Comparator<NumFreq>() {
            public int compare(NumFreq a, NumFreq b) {
                if (a.freq != b.freq) {
                    return a.freq - b.freq;
                } else {
                    return b.num - a.num;
                }
            }
        });
        
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nf[i].num;
        }
        
        return res;
    }
    
    class NumFreq {
        public int num;
        public int freq;
        
        public NumFreq(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    */
    
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i] + 100]++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // 频次放在高位，排序后高频次元素在后
            // 原数据 “取反”，使原本的大数据变小，排序后使其更靠前
            nums[i] = freq[nums[i] + 100] * 1000 + 100 - nums[i];
        }
    
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 100 - nums[i] % 1000;
        }
      
        return nums;
    }
}