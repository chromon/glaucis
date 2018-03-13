public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        int cursor = 0;
        
        if(A == null) {
            return 0;
        }
        
        for(int i = 0; i < A.length; i ++) {
            if(target == A[i]) {
                return i;
            } else if(target > A[i]) {
                cursor = i + 1;
            } else {
                break;
            }
        }
        
        return cursor;
    }
}