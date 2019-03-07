class Solution {
    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }
        // 如果一个数为2^n，那么它的二进制形式为10000...000这种形式，而2^n - 1一定是0111...111这种形式，这两个数做“与”运算就一定会导致结果是0。
        return (n & (n - 1)) == 0;
    }
}