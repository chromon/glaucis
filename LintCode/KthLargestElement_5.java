class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    
    public void quickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int mi = partition(nums, lo, hi);
            quickSort(nums, lo, mi);
            quickSort(nums, mi + 1, hi);
        }
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        
        while (lo < hi) {
            
            while ((lo < hi) && (pivot <= nums[hi])) {
                hi --;
            }
            
            nums[lo] = nums[hi];
            
            while ((lo < hi) && (nums[lo] <= pivot)) {
                lo ++;
            }
            
            nums[hi] = nums[lo];
        }
        
        nums[lo] = pivot;
        
        return lo;
    }
};