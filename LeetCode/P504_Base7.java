/*
504. Base 7
Easy

Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"
 

Constraints:

-107 <= num <= 107
*/

class Solution {
    public String convertToBase7(int num) {
        
        int res = 0;
        boolean negative = false;
        StringBuilder sb = new StringBuilder();
        
        if (num == 0) {
            return "0";
        }
        
        if (num < 0) {
            negative = true;
            num = num * -1;
        }
        
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        
        if (negative) {
            sb.insert(0, "-");
        }
        
        return sb.toString();
    }
}