class Solution {
    public int trailingZeroes(int n) {
       
        // 只有 5 能产生 0，只需返回 n 的因子中 5 的个数 
        int count = 0;
        
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        
        return count;
    }
}