/*
322. Coin Change
Medium

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/

class Solution {
    /*
    // ⾃顶向下
    private Map<Integer, Integer> map = new HashMap<>();
    
    public int coinChange(int[] coins, int amount) {
        
        if (map.get(amount) != null) {
            return map.get(amount);
        }
        
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        
        int res = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        
        if (res != Integer.MAX_VALUE) {
            map.put(amount, res);
        } else {
            map.put(amount, -1);
        }
        
        return map.get(amount);
    }
    */
    
    // ⾃底向上
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        // dp[i] 表示达到 i 用的最少硬币数
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // dp[i] 最大值为 amount，即全由 1 组成
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1? -1: dp[amount];
    }
}