public class Solution {
    /**
     * @param nums: An integer array
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        // write your code here
        int maxNum=nums[0]>nums[1]?nums[0]:nums[1];
        int maxNum2=nums[0]<nums[1]?nums[0]:nums[1];
        for (int i=2;i<nums.length;i++) {
            if (nums[i]>maxNum) {
                maxNum2=maxNum;
                maxNum=nums[i];
            } else if (nums[i]>maxNum2) maxNum2=nums[i];
        }

        return maxNum2;
    }
}