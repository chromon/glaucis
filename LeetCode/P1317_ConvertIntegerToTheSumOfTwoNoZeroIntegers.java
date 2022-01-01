/*
1317. Convert Integer to the Sum of Two No-Zero Integers
Easy

No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

Given an integer n, return a list of two integers [A, B] where:

A and B are No-Zero integers.
A + B = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions you can return any of them.

 

Example 1:

Input: n = 2
Output: [1,1]
Explanation: A = 1, B = 1. A + B = n and both A and B do not contain any 0 in their decimal representation.
Example 2:

Input: n = 11
Output: [2,9]
 

Constraints:

2 <= n <= 104
*/

class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        int a = 0;
        int b = 0;
        
        for (int i = 1; i < n; i++) {
            a = n - i;
            b = i;
            if (noZero(a) && noZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[2];
    }
    
    private boolean noZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}