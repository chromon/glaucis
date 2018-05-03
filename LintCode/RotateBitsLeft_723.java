public class Solution {
    /**
     * @param n: a number
     * @param d: digit needed to be rorated
     * @return: a number
     */
    public int leftRotate(int n, int d) {
        // write code here
        // 先把integer n 32 bits 形式的最左边位数存为一个单独的integer left。 
        // 然后将 n 左shift d位后加上left就完成了rotate bits - left
        int left = 0;
        for (int i = 0; i < d; ++i) {
            left = left * 2 + n & (1 << (31 - i));
        }
        return n << d + left;
    }
}