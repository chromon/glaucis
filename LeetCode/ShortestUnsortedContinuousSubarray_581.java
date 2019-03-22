class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        Arrays.sort(arr);
        
        int i = 0, j = nums.length - 1;
        
        while (i < nums.length && arr[i] == nums[i]) {
            i++;
        }
        
        while ((j > i + 1) && arr[j] == nums[j]) {
            j--;
        }
        
        return j - i + 1;
    }
}