class Solution {
    public boolean isMonotonic(int[] A) {
        
        boolean asc = true;
        boolean desc = true;
        
        for (int i = 0; i < A.length - 1; i++) {
            asc = asc && (A[i] <= A[i + 1]);
            desc = desc && (A[i] >= A[i + 1]);
        }
        
        return asc || desc;
    }
}