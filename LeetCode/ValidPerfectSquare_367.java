class Solution {
    /*public boolean isPerfectSquare(int num) {
        
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        
        return false;
    }*/
    
    public boolean isPerfectSquare(int num) {
        // 利用 1+3+5+7+9+…+(2n-1)=n^2，即完全平方数肯定是前n个连续奇数的和
        
        int sum = 1;
        
        while (num > 0) {
            num -= sum;
            sum += 2;
        }
        
        return num == 0;
    }
}