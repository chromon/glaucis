public class Solution {
    /**
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        /* 
            n与n - 1的关系：当n是偶数，n -1是奇数，二进制形式中，
            那么n - 1就是偶数n 的尾巴上的所有0（直到倒数第一个1为止），
            全部变为1，且倒数第一个1变为0. 
            例如：142：10100000；141：10011111. 
            
            根据上面的理论，如果一个数为2^n，那么它的二进制形式为10000...000这种形式，
            而2^n - 1一定是0111...111这种形式，这两个数做“与”运算就一定会导致结果是0。
            所以，我们需要做的工作就是判断一个数n, n & (n-1)是不是等于0.
        */
        return n > 0 && ((n & (n - 1)) == 0);
    }
}