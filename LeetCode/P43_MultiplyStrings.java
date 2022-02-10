/*
43. Multiply Strings
Medium

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/

class Solution {
    /*
        设 m 和 n 分别为 num1 和 num2 的长度，并且它们均不为 0，
        则 num1 和 num2 的乘积的长度为 m+n−1 或 m+n。

        - 若 num1 和 num2 分别取最小值 10^(m - 1) 和 10^(n - 1)，则 num1 * num2 为
          10^(m + n - 2)，所以结果的长度为 m + n - 1;
        
        - 若 num1 和 num2 分别取最大值 10^m - 1 和 10^n - 1，则 num1 * num2 为
          10^(m + n) - 10^m - 10^n + 1，乘积显然小于 10^(m + n) 且大于 10^(m + n - 1)，
          因此乘积的最大长度为 m + n。
          
        创建长度为 m+n 的数组 arr 用于存储乘积。对于任意 0 <= i < m 和 0 <= j < n，
        num1[i] * num2[j] 的结果位于 arr[i + j + 1]，如果 arr[i + j + 1] >= 10，
        则将进位部分加到 arr[i + j]。
    */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                arr[i + j + 1] += a * b;
            }
        }
        
        // 处理进位
        for (int i = m + n - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        
        // 去掉前导 0
        int index = arr[0] == 0? 1: 0;
        StringBuilder sb = new StringBuilder();
        while (index < arr.length) {
            sb.append(arr[index]);
            index++;
        }
        
        return sb.toString();
    }
}