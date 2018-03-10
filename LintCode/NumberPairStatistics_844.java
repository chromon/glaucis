public class Solution {
    /**
     * @param p: the point List
     * @return: the numbers of pairs which meet the requirements
     */
    public int pairNumbers(Point[] p) {
        // Write your code here
        int count = 0;
        
        for(int i = 0; i < p.length; i ++) {
            for(int j = 0; (j < p.length) && (j != i); j ++) {
                if((p[i].x + p[j].x) % 2 == 0 && (p[i].y + p[j].y) % 2 == 0) {
                    count ++;
                }
            }
        }
        
        return count;
    }
}