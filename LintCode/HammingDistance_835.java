public class Solution {
    /**
     * @param x: an integer
     * @param y: an integer
     * @return: return an integer, denote the Hamming Distance between two integers
     */
    public int hammingDistance(int x, int y) {
        // write your code here
        
        // 假如数为num, num & (num - 1)可以快速地移除最右边的bit 1， 一直循环到num为0, 总的循环数就是num中bit 1的个数
        int res = 0, exc = x ^ y;
        
        while (exc != 0) {
            res ++;
            exc &= (exc - 1);
        }
        
        return res;
    }
}