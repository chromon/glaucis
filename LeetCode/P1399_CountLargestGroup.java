/*
1399. Count Largest Group
Easy

You are given an integer n.

Each number from 1 to n is grouped according to the sum of its digits.

Return the number of groups that have the largest size.

 

Example 1:

Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.
Example 2:

Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.
 

Constraints:

1 <= n <= 104
*/

class Solution {
    public int countLargestGroup(int n) {
        // <sum, count>
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            int sum = sum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        int res = 0;
        int maxCount = 0;
        
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() > maxCount) {
                maxCount = e.getValue();
                res = 1;
            } else if (e.getValue() == maxCount) {
                res++;
            }
        }
        
        return res;
    }
    
    private int sum(int n) {
        int sum = 0;
        
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}