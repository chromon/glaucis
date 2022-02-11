/*
47. Permutations II
Medium

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/

/*
    重复问题：
    
    存在相同数字，比如 [1,2,2']，那么 [1,2,2'] 和 [1,2',2] 就其实是一样的，在保存结果的时候，
    只选择其一。
    
    如果发现数字重复了，当前的就不再考虑，比如 [1,2,2'] 存在之后，当遇到 [1] 遇到 2'，
    发现和 2 重复，就直接剪枝，不考虑之后的所有的情况。
    
    重复元素时先排序，将重复的都放在一起，便于找到重复元素和剪枝。
    
    使用数组 visited 记录所有已访问的元素。
*/
class Solution {
    
    List<List<Integer>> res = new LinkedList<>();
    // 记录所有已访问的元素
    boolean[] visited;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(nums, path);
        return res;
    }
    
    private void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            // 当前索引 i 已经遍历过，同时添加到 path 中，跳过
            // 如果索引 i 没有遍历过，但其前一个元素与当前元素相同且遍历过，跳过
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
                continue;
            }
            
            visited[i] = true;
            path.add(nums[i]);
            
            backtrack(nums, path);
            
            path.removeLast();
            visited[i] = false;
        }
    }
}