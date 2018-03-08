public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        
        // 或运算符的规则，一个数和0异或还是自己，一个数和自己异或是0
        int t = 0;
        
        for(int i = 0; i < A.length; i ++) {
            t ^= A[i];
        }
        
        return t;
    }
}