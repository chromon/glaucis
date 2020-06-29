class Solution {
    public int countPrimeSetBits(int L, int R) {
        
        int sum = 0;
        
        for (int i = L; i <= R; i++) {
            if (isPrime(hammingWeight(i))) {
                sum++;
            }
        }
        
        return sum;
    }
    
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            n = n & (n - 1);
            count ++;
        }
        
        return count;
    }
    
    public boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        
        int sqrt = (int)Math.sqrt(n);
        
        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}