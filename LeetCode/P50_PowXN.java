/*
50. Pow(x, n)
Medium

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
*/

class Solution {
    /*
        当要计算 x^n 时，可以先递归地计算出 y = x^⌊n/2⌋，其中 ⌊a⌋ 表示对 a 进行下取整；
        根据递归计算的结果，如果 n 为偶数，那么 x^n = y^2；如果 n 为奇数，那么 x^n = y^2 * x；
    */
    public double myPow(double x, int n) {
        return n >= 0? quickMul(x, n): 1.0 / quickMul(x, n);        
    }
    
    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        
        double y = quickMul(x, n / 2);
        return n % 2 == 0? y * y: y * y * x;
    }
}