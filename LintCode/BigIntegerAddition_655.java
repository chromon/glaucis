public class Solution {
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        
        int max = num1.length() > num2.length()? num1.length(): num2.length();
        int[] res = new int[max + 1];
        
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        
        int i = c1.length - 1, j = c2.length - 1, k = res.length - 1;
        int t = 0;
        for(; i >= 0 && j >= 0; i --, j --, k --) {
            int sum = (c1[i] - '0') + (c2[j] - '0') + t;
            t = 0;
            if(sum > 9) {
                sum -= 10;
                t = 1;
            }
            res[k] = sum;
        }
        
        if(c1.length > c2.length) {
            for(; i >= 0; i --, k --) {
                int sum = (c1[i] - '0') + t;
                t = 0;
                if(sum > 9) {
                    sum -= 10;
                    t = 1;
                }
                res[k] = sum;
            }
        } else if(c1.length < c2.length) {
            for(; j >= 0; j --, k --) {
                int sum = (c2[j] - '0') + t;
                t = 0;
                if(sum > 9) {
                    sum -= 10;
                    t = 1;
                }
                res[k] = sum;
            }
        } else {
            res[k] = t;
        }
        
        res[k] = t;
        
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        
        for(int x = 0; x < res.length; x ++) {
            if(res[x] != 0) {
                flag = true;
            }
            
            if(flag) {
                sb.append(res[x]);
            }
        }
        
        if(! flag) {
            sb.append(0);
        }
        
        return sb.toString();
    }
}