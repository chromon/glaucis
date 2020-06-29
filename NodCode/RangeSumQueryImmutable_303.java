class NumArray {
    
    /*
    223 ms	47 MB
    private int[] n;

    public NumArray(int[] nums) {
        this.n = nums;
    }
    
    public int sumRange(int i, int j) {
        
        int sum = 0;
        
        for (int t = i; t <= j; t++) {
            sum += n[t];
        }
        
        return sum;
    }
    */
    
    private int[] nums;
    private int[] sum;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        
        if (nums.length != 0) {
            sum[0] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }
    
    // 会多次调用 sumRange 方法
    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        
        return sum[j] - sum[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */