public class Solution {
    /**
     * @param x: the wall's height
     * @return: YES or NO
     */
    public String isBuild(int x) {
        // write you code here
        
        for(int i = 0; i <= 1000 / 3; i ++) {
            for(int j = 0; j <= 1000 / 7; j ++) {
                if(3 * i + 7 * j == x) {
                    return "YES";
                }
            }
        }
        return "NO";
        
    }
}