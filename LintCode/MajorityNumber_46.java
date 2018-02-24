public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        
        int len = nums.size() / 2 + 1;
        
        
        int t = 0;
        
        for(int i: nums) {
            int count = 0;
            t = i;
            
            for(int j: nums) {
                if(i == j) {
                    count ++;
                }
            }
            
            if(count >= len) {
                break;
            }
        }
        
        return t;
    }
}