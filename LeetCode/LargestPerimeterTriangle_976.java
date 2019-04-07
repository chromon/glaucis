class Solution {
    public int largestPerimeter(int[] A) {
        
        Arrays.sort(A);
        int sum = 0;
        
        for (int i = A.length - 1; i >= 2; i--) {
            int a = A[i];
            int b = A[i - 1];
            int c = A[i - 2];
            if (a + b > c && a + c > b && b + c > a) {
                sum = a + b + c;
                break;
            }
        }
        
        return sum;
    }
}