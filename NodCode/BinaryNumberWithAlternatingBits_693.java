class Solution {
    public boolean hasAlternatingBits(int n) {
        
        /*
            101  111
            010  011
            111 1000
           1000  111
              0    0
        */
        
        int tmp = n + (n >> 1);
        return (tmp & (tmp + 1)) == 0;
    }
}