class Solution {
    public int missingNumber(int[] nums) {
        
        /*
            0 ^ 3 = 3;
            3 ^ 3 = 0;
            
            1 ^ 1 ^ 2 ^ 2 ^ 3 = 3;
        */
        
        int t = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            t ^= nums[i];
            t ^= i;
        }
        
        return t;
    }
}