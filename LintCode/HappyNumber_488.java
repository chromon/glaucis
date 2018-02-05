public class Solution {
    /*
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // write your code here
        
        int tmp = n;
        int newNum = n;
        
        while(newNum != 1) {
            
            // 如果不是快乐数，无限循环里会有 4
            if(newNum == 4) {
                return false;
            }
            
            tmp = newNum;
            newNum = 0;
            
            while(tmp != 0) {
                newNum += (tmp % 10) * (tmp % 10);
                tmp = tmp / 10;
            }
        }
        return true;
    }
}