class Solution {
    public double largestTriangleArea(int[][] points) {
        
        // S=(1/2)*(x1y2+x2y3+x3y1-x1y3-x2y1-x3y2)
        double res = 0;
        for (int[] x : points) {
            for (int[] y : points) {
                for (int[] z : points) {
                    res = Math.max(res, 0.5 * (x[0] * y[1] + y[0] * z[1] + z[0] * x[1]
                           - x[0] * z[1] - y[0] * x[1] - z[0] * y[1]));
                }
            }
        }
        return res;
    }
}