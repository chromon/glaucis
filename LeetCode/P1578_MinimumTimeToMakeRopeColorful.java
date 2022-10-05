/*
1578. Minimum Time to Make Rope Colorful
Medium

Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.

 

Example 1:


Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.
Example 2:


Input: colors = "abc", neededTime = [1,2,3]
Output: 0
Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.
Example 3:


Input: colors = "aabaa", neededTime = [1,2,3,4,1]
Output: 2
Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
 

Constraints:

n == colors.length == neededTime.length
1 <= n <= 105
1 <= neededTime[i] <= 104
colors contains only lowercase English letters.
*/

class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        // 如果字符串 colors 中有若干相邻的重复颜色，则这些颜色中最多只能保留一个。
        // 可以采取贪心的策略：在这一系列重复颜色中，我们保留删除成本最高的颜色，
        // 并删除其他颜色。这样得到的删除成本一定是最低的。

        int i = 0;
        int len = colors.length();
        int res = 0;
        
        while (i < len) {
            char ch = colors.charAt(i);
            int maxValue = 0;
            int sum = 0;

            while (i < len && colors.charAt(i) == ch) {
                maxValue = Math.max(maxValue, neededTime[i]);
                sum += neededTime[i];
                i++;
            }
            res += sum - maxValue;
        }
        return res;
    }
}