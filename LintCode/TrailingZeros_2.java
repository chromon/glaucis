public class Solution {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.

        /*
        考虑到只要有5，或者因子为5的数，就可以产生0的尾部。
        假如1*2*3*4*...*250,那么250/5=50可以知道，有50个为5的倍数，
        但是里面有多少个为25的倍数，125的倍数..., 50/5=10，可知25的倍数有10个，
        10/5=2，可知125的倍数有两个，以此类推
        */
        
        long num = 0;
        
        while(n != 0) {
            num += n / 5;
            n = n / 5;
        }
        
        return num;
    }
}