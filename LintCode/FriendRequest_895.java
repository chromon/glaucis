public class Solution {
    /**
     * @param ages: The ages
     * @return: The answer
     */
    public int friendRequest(int[] ages) {
        // Write your code here
        int count = 0;
        
        for(int i = 0; i < ages.length; i ++) {
            for(int j = 0; j < ages.length; j ++) {
                if((i != j) && (ages[j] > ages[i] / 2 + 7) && (ages[j] <= ages[i]) 
                    && ! (ages[j] < 100 && ages[i] > 100)) {
                    count ++;
                }
            }
        }
        
        return count;
    }
}