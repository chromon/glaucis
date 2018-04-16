public class Solution {
    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    public int[] countBits(int num) {
        // write your code here
        int[] res = new int[num + 1];
        
        for (int i = 0; i <= num; i++) {
            res[i] = count1(i);
        }
        
        return res;
    }
    
    // version 1.
    // public int count1(int n) {
    //     int count = 0;
        
    //     while (n > 0) {
    //         n = n & (n - 1);
    //         count ++;
    //     }
        
    //     return count;
    // }
    
    // version 2.
    public int count1(int n) {
        int temp = 0;

        temp = n
            - ((n >> 1) & 033333333333)
            - ((n >> 2) & 011111111111);

        temp = (temp + (temp >> 3)) & 030707070707;

        return (temp % 63);
    }
}