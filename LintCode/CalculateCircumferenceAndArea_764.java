public class Solution {
    /**
     * @param r: a Integer represent radius
     * @return: the circle's circumference nums[0] and area nums[1]
     */
    public double[] calculate(int r) {
        // write your code here
        
        final double PI = 3.14;
        
        double[] nums = new double[2];
        
        nums[0] = 2 * PI * r;
        nums[1] = PI * r * r;
        
        return nums;
    }
}