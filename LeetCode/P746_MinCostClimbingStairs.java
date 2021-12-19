/*
746. Min Cost Climbing Stairs
Easy

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 

Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999
*/

class Solution {
    /*
    // Time Limit Exceeded
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(indexCost(cost, 0), indexCost(cost, 1));
    }
    
    private int indexCost(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }
        
        return cost[index] + Math.min(indexCost(cost, index + 1), 
                                  indexCost(cost, index + 2));
    }
    */
    
    /*
    到第 n 个台阶的 mincost 是到第 n-1 个台阶的 mincost 和
    到第 n-2 个台阶的 mincost 的小者再加上第 n 个台阶的花费。
    */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        return Math.min(dp[n - 1], dp[n - 2]);
    }
    
}