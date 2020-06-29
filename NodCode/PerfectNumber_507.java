class Solution {
    public boolean checkPerfectNumber(int num) {
        
        if (num == 1) {
            return false;
        }
        
        // 1 一定是因子
        int res = 1;
        
        // a*b=num，如果ab相等，则a等于根号num，如果a大于根号num，那么b一定小于根号num
        // 所以只要求出根号num前即可，后序可有num/i求出
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res += i + num / i;
            }
        }
        
        return res == num;
    }
}