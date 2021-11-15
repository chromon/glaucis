/*
46. Permutations
Medium

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

class Solution {
    
    private List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }
    
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            
            // 做选择
            track.add(nums[i]);
            // 进⼊下⼀层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}