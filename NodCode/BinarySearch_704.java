class Solution {
    public int search(int[] nums, int target) {
        
        int lo = 0, hi = nums.length - 1;
        int mi = 0;
        
        while (lo <= hi) {
            mi = (hi + lo) / 2;
            if (target < nums[mi]) {
                hi = mi - 1;
            } else if (target > nums[mi]) {
                lo = mi + 1;
            } else {
                return mi;
            }
        }
        
        return -1;
    }
}