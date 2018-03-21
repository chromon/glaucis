public class Solution {
    /*
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here
        int n = nums.length;
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i ++) {
            l = Math.min(l, (double) nums[i]);
            r = Math.max(r, (double) nums[i]);
        }
        
        double[] sumNums = new double[n + 1];
        sumNums[0] = 0;
        
        while(r - l > 1e-6) {
            double mid = (l + r) / 2;
            
            for(int i = 0; i < n; i ++) {
                sumNums[i + 1] = sumNums[i] + nums[i] - mid;
            }
            
            double preMin = 0;
            double sumMax = Integer.MIN_VALUE;
            
            for(int i = k; i <= n; i ++) {
                sumMax = Math.max(sumMax, sumNums[i] - preMin);
                preMin = Math.min(preMin, sumNums[i - k + 1]);
            }
            
            if(sumMax >= 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
}