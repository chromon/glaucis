/*
405. Convert a Number to Hexadecimal
Easy

Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.

 

Example 1:

Input: num = 26
Output: "1a"
Example 2:

Input: num = -1
Output: "ffffffff"
 

Constraints:

-231 <= num <= 231 - 1
*/

class Solution {
    public String toHex(int num) {
        
        if (num == 0) {
            return "0";
        }
        
        String[] map = {"0", "1", "2", "3", "4", "5", "6", "7", 
                      "8", "9", "a", "b", "c", "d", "e", "f"};

        String res = "";
        while (num != 0) {
            // 二进制的最低 4 位 & 15 得到 16 进制的最低位 1 位
            res = map[(num & 15)] + res;
            num = num >>> 4;
        }
        
        return res;
    }
}