class Solution {
    public int countPrimes(int n) {
        
        /*
            如果一个数是另一个数的倍数，那这个数肯定不是质数。
            利用这个性质，可以建立一个质数数组，从2开始将素数的倍数都标注为不是质数。
            第一轮将4、6、8等表为非质数，然后遍历到3，发现3没有被标记为非质数，
            则将6、9、12等标记为非质数，一直到N为止，再数一遍质数数组中有多少质数。
        */
        
        // false = prime
        boolean[] b = new boolean[n];
        
        for (int i = 2; i < n; i++) {
            if (!b[i]) {
                // 将i的2倍、3倍、4倍...都标记为非素数
                for (int j = i * 2; j < n; j += i) {
                    b[j] = true;
                }
            }
        }
        
        int count = 0;
        
        // 质数大于 1
        for (int i = 2; i < n; i++) {
            if (!b[i]) {
                count++;
            }
        }
        
        return count;
    }
}