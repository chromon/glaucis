public class Solution {
    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     */
    public boolean isPerfectSquare(int num) {
        // write your code here
        
        for(int i = 1; i <= num / i; i ++) {
            if(i * i == num) {
                return true;
            }
        }
        return false;
    }
}