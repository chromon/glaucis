class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] res = new int[2];
        int[] tmp = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i] - 1]++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (tmp[i] == 2) {
                res[0] = i + 1;
            } else if (tmp[i] == 0) {
                res[1] = i + 1;
            }
        }
        
        
        return res;
    }
}