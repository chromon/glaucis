public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        List<Long> result = new ArrayList<>();
        
        int n = nums.size();
        
        if(n == 0) {
            return result;
        }
        
        long t = 1;
        left.add(1L);
        for(int i = 0; i < n - 1; i ++) {
            t *= nums.get(i);
            left.add(t);
        }
        
        t = 1;
        right.add(1L);
        for(int i = n - 1; i > 0; i --) {
            t *= nums.get(i);
            right.add(t);
        }
        
        for(int i = 0; i < n; i ++) {
            result.add(left.get(i) * right.get(n - i - 1));
        }
        
        return result;
    }
}