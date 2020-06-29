/*
7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution {
    public int reverse(int x) {
        
        boolean sign = false;
        
        if (x < 0) {
            sign = true;
            x *= -1;
        }
        
        long res = 0;
        while (x > 0) {
            int t = x % 10;
            x = x / 10;
            res = res * 10 + t;
        }
        
        if (sign) {
            res *= -1;
        }
        
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        
        return (int) res;
    }
}