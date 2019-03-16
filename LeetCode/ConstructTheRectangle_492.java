class Solution {
    public int[] constructRectangle(int area) {
        
        // w = 最接近 sqrt(area)的因数, l = area/w;
        int sqrt = (int)Math.sqrt(area);
        int[] res = new int[2];
        
        for (int i = sqrt; i > 0; i--) {
            if (area % i == 0) {
                res[0] = area / i;
                res[1] = i;
                break;
            }
        }
        
        return res;
    }
}