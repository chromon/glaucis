public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        int low = 0, high = A.length - 1, size = A.length, mid = 0;

        if (size <= 0) {
            return -1;
        }
        while (low <= high) {
            mid = (high + low) / 2; 
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] >= A[low]) {
                if(A[low] <= target && target < A[mid]) {
                    high = mid - 1;
                } else  {
                    low = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[high])  {
                    low = mid + 1;
                } else  {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}