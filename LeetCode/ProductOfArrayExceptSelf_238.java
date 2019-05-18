class Solution {
    public int[] productExceptSelf(int[] nums) {
        //从左到右乘一次，从右到左乘一次。
        //即sums[i]应等于左边的乘积*右边的乘积;
        int []sum = new int[nums.length];
        int left = 1;
        for (int i = 0; i < sum.length; i++) {
            sum[i] = left;
            left = left * nums[i];
        }
        
        int right = 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            sum[i] = sum[i] * right;
            right = right * nums[i];
        }
        
        return sum; 
    }
}