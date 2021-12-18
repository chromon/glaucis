/*
693. Binary Number with Alternating Bits
Easy

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 

Example 1:

Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101
Example 2:

Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
Example 3:

Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.
 

Constraints:

1 <= n <= 231 - 1
*/

class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int t = n % 2;
        n = n / 2;
        
        while (n > 0) {
            int i = n % 2;
            if (i == t) {
                return false;
            }
            
            t = i;
            n = n / 2;
        }
        return true;
    }
}