public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return 1;
        }
        
        int t = 0;
        int tmp = 0;
        
        for(int i = 1; i < nums.length; i ++) {
            
            if(nums[t] != nums[i]) {
                t ++;
                nums[t] = nums[i];
                tmp = 0;
            } else {
                if(tmp == 0) {
                    tmp ++;
                    t ++;
                    // 相同数字超过4个时才有用，如[1,1,1,1,1,2,2,2,2,2]
                    nums[t] = nums[i];
                }
            }
        }
        
        return t + 1;
    }
}