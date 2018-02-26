public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        int min = nums.get(0);
        int sum = 0;
        
        for(int i = 0; i < nums.size(); i ++) {
            sum += nums.get(i);
            
            if(sum < min) {
                min = sum;  
            }
            
            if(sum > 0) {
                sum = 0;
            }
        }
        
        return min;
    }
}