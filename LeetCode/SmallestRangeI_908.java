class Solution {
    public int smallestRangeI(int[] A, int K) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i: A) {
            if (i > max) {
                max = i;
            }
            
            if (i < min) {
                min = i;
            }
        }
        
        if ((max - min) <= 2 * K) {
            return 0;
        }
        
        return max - min - 2 * K;
    }
}