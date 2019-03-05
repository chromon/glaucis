class Solution {
    /*public void rotate(int[] nums, int k) {
        // 234 m  39.1 MB
        k %= nums.length;
        
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = tmp;
        }
    }*/
    
    
    public void rotate(int[] nums, int k) {
        // 1ms
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}