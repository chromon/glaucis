public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        /*
        任何丑数都可以表示为：i^2 * j^3 * k^5；后一个丑数等于前面某个丑数乘以2或3或5：

        定义一个大小为n的数组u[n]用来存储有序丑数序列。
        三个游标u2,u3,u5分别表示乘以2或3或5取得过最新丑数。
        下一个丑数等于min(u[u2]*2, u[u3]*3, u[u5]*5)，并根据因子对u2或u3或u5递增。
        */
        int[] u = new int[n];
        u[0] = 1;
        int u2 = 0, u3 = 0, u5 = 0;
        
        for (int i = 1; i < n; i++) {
            u[i] = min(min(u[u2]*2,u[u3]*3),u[u5]*5);
            
            if((u[i]/u[u2]) == 2) {
                u2++;
            }
            if((u[i]/u[u3]) == 3) {
                u3++;
            }
            if((u[i]/u[u5]) == 5) {
                u5++;
            }
        }
        return u[n-1];
    }
    
    public int min(int a, int b){
        return a < b ? a: b;
    }
}