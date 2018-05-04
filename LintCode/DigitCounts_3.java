public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        char ks = (char) (k + '0');
        int count = 0;
        
        for (int i = 0; i <= n; i ++) {
            String ns = i + "";
            
            for (int j = 0; j < ns.length(); j ++) {
                if (ns.charAt(j) == ks) {
                    count ++;
                }
            }
        }
        
        return count;
    }
};