class Solution {
    public boolean validMountainArray(int[] A) {
        
        if (A.length < 3) {
            return false;
        }
        
        int i = 1;
        
        for (; i < A.length && A[i - 1] < A[i]; i++); 
        
        if (i == 1 || i == A.length) {
            return false;
        }
        
        for (; i < A.length && A[i - 1] > A[i]; i++);
        
        return i == A.length;
    }
}