class Solution {
    /*public int addDigits(int num) {
        
        int n = num;
        
        while (n / 10 != 0) {
            int sum = 0;
            sum += n % 10;
            sum += n / 10;
            n = sum;
        }
        
        return n;
    }*/
    
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        
        int n = num % 9;
        
        return n == 0? 9: n;
    }
}