class Solution {
    public int singleNumber(int[] nums) {
        
        int t = 0; 
        
        // 异或：相同为 0，不同为 1
        // 与 0 异或为本身，与本身异或为 0
        for (int i = 0; i < nums.length; i++) {
            t ^= nums[i];
        }
        
        return t;
    }
}