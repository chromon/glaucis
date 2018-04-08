public class Solution {
    /*
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes(int num) {
        // write your code here
        
        // num & (num - 1)可以快速地移除最右边的bit 1
        int count = 0;
        
        while(num != 0) {
            count ++;
            num &= num - 1;
        }
        
        return count;
    }
};