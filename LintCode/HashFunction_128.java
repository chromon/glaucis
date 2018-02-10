public class Solution {
    /*
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    // public int hashCode(char[] key, int HASH_SIZE) {
    //     // write your code here
    //     long tmp = 0;
        
    //     int i = key.length - 1, j = 0;
    //     while(i >= 0 && j < key.length) {
            
    //         tmp += ((int) key[j]) * pow(33, i);
            
    //         i --;
    //         j ++;
    //     }
        
    //     tmp %= HASH_SIZE;
        
    //     return new Long(tmp).intValue();
    // }
    
    // private int pow(int m, int n) {
    //     int t = 1;
    //     for(int i = 0; i < n; i ++) {
    //         t *= m;
    //     }
    //     return t;
    // }
    
    /*
        hashcode(abc)=(33(33(33×0+a)+b)+c)%M， 
        (a×b)%M=((a%M)×(b%M))%M
    */
    public int hashCode(char[] key, int HASH_SIZE) {
        
        long tmp = 0;
        
        for(int i = 0; i < key.length; i ++) {
            tmp = tmp * 33 + (byte) key[i];
            tmp %= HASH_SIZE;
        }
        
        return new Long(tmp).intValue();
    }
}