class Solution {
    public int minMoves(int[] nums) {
        
        // 每次最优的操作就是把除了最大的数的其他数全部加一，也就相当于把最大的数减一，那么把所有的数全部减到最小数就可以了
        int min = Integer.MAX_VALUE;
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - min;
        }
        
        return res;
    }
}