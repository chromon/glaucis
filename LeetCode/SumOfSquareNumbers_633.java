class Solution {
    public boolean judgeSquareSum(int c) {
        
        int a = 0;
        int b = (int)Math.sqrt(c);
        
        while (a <= b) {
            int tmp = c - a * a - b * b;
            if (tmp > 0) {
                a++;
            } else if (tmp < 0) {
                b--;
            } else {
                return true;
            }
        }
        
        return false;
    }
}