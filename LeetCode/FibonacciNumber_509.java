class Solution {
    public int fib(int N) {
        
        if (N <= 0) {
            return 0;
        }
        
        if (N == 1) {
            return 1;
        }
        
        int a = 0;
        int b = 1;
        int res = 0;
        
        for (int i = 2; i <= N; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        
        return res;
    }
}