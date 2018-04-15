public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        
        /*
            一个全排列， 例如：95412 = X

            题目转换成按照字典序，这个全排列之前有多少个全排列。
            
            X的前面的所有全排列中，对于位置1上可以是5, 4, 1, 2任意一个数，而且对应的全排列的基数都是4!个。
            
            同理位置2, 3, 4, 5对应的基数分别是，3！，2！，1！，0！(0!==0)。
            
            得到该位置对应的基数后，那么该位置对应多少个可变数字？9所在位置对应的可变数字的个数为4，分别是5,4,1,2；5所在位置对应的可变数字是4,1,2；4所在位置对应的可变数字是1,2,；1所在位置的对应的可变数字:无。2所在位置对应可变数也是无。
            
            可以得到结论，X全排列某个位置上对应的可变数字的个数 == 这个数后面有多少个比它小的数的个数。
            
            为了得到某个数后面有多少个比它小的数的个数，我们采用折半插入排序（从后向前插入）。
        */
        long ans = 0;
        
        for (int i = 0; i < A.length; i ++) {
            for (int j = i + 1; j < A.length; j ++) {
                if (A[j] < A[i]) {
                    ans += fac(A.length - i - 1);
                }
            }
        }
        
        return ans + 1;
    }
    
    public long fac(int n) {
        long ans = 1;
        
        for (int i = 1; i <= n; i ++) {
            ans *= (long)i;
        }
        
        return ans;
    }
}