/*
40. Combination Sum II
Medium

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/

class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtrace(path, candidates, target, 0, 0);
        return list;
    }
    
    private void backtrace(List<Integer> path, int[] candidates, 
                                int target, int sum, int start) {
        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            int newSum = candidates[i] + sum;
            if (newSum <= target) {
                path.add(candidates[i]);
                backtrace(path, candidates, target, newSum, i + 1);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
        
    }
}