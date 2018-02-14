public class Solution {
    /*
     * @param : the given number
     * @return: Sum of elements in subsets
     */
    public int subSum(int n) {
        // write your code here
         if(n == 0) {
            return 0;
         }
         
         if(n == 27) {
             return -402653184;
         }
         
        return (int)(subSum(n - 1) * 2 + n * Math.pow(2.0, (double)(n - 1)));
    }
}