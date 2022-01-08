/*
1556. Thousand Separator
Easy

Given an integer n, add a dot (".") as the thousands separator and return it in string format.

 

Example 1:

Input: n = 987
Output: "987"
Example 2:

Input: n = 1234
Output: "1.234"
 

Constraints:

0 <= n <= 231 - 1
*/

class Solution {
    public String thousandSeparator(int n) {
        
        if (n < 1000) {
            return String.valueOf(n);
        }
        
        int k = 0;
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            k++;
            int t = n % 10;
            
            n /= 10;
            sb.insert(0, t);
            
            if (k == 3) {
                sb.insert(0, ".");
                k = 0;
            }
        }
        
        String res = sb.toString();
        if (res.startsWith(".")) {
            res = res.substring(1);
        }
        
        return res;
    }
}