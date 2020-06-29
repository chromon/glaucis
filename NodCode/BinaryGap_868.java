class Solution {
    public int binaryGap(int N) {
        
        int res = 0;
        
        while ((N & 1) != 1) {
            N >>= 1;
        }
        
        int tmp = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                res = tmp > res ? tmp : res;
                tmp = 0;
            }
            
            tmp++;
            N >>= 1;
        }
        
        return res;
    }
}