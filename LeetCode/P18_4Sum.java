/*
18. 4Sum
Medium

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/

class Solution {
    /*
        使用两重循环分别枚举前两个数，然后在两重循环枚举到的数之后使用双指针枚举剩下的两个数。
        
        假设两重循环枚举到的前两个数分别位于下标 i 和 j，其中 i < j。
        初始时，左右指针分别指向下标 j + 1 和下标 n − 1。
        
        每次计算四个数的和，并进行如下操作：
        - 如果和等于 target，则将枚举到的四个数加到答案中，然后将左指针右移直到遇到不同的数，
          将右指针左移直到遇到不同的数；
        - 如果和小于 target，则将左指针右移一位；
        - 如果和大于 target，则将右指针左移一位。

        具体实现时，还可以进行一些剪枝操作：

        - 在确定第一个数之后，如果 nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target，
          说明此时剩下的三个数无论取什么值，四数之和一定大于 target，因此退出第一重循环；
        
        - 在确定第一个数之后，如果 nums[i] + nums[n − 3] + nums[n − 2] + nums[n − 1] < target，
          说明此时剩下的三个数无论取什么值，四数之和一定小于 target，因此第一重循环直接进入下一轮，           枚举 nums[i + 1]；
          
        - 在确定前两个数之后，如果 nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target，
          说明此时剩下的两个数无论取什么值，四数之和一定大于 target，因此退出第二重循环；
          
        - 在确定前两个数之后，如果 nums[i] + nums[j] + nums[n − 2] + nums[n - 1] < target，
          说明此时剩下的两个数无论取什么值，四数之和一定小于 target，因此第二重循环直接进入下一轮，
          枚举 nums[j+1]。
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return res;
        }
            
        Arrays.sort(nums);
            
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] 
                    + nums[length - 1] < target) {
                continue;
            }
            
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}