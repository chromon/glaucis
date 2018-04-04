public class Solution {
    /**
     * @param Matrix: the input
     * @return: the element which appears every row
     */
    public int FindElements(int[][] Matrix) {
        // write your code here
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < Matrix.length; i ++) {
            for(int j = 0; j < Matrix[0].length; j ++) {
                if(! map.containsKey(Matrix[i][j])) {
                    map.put(Matrix[i][j], 1);
                } else {
                    map.put(Matrix[i][j], map.get(Matrix[i][j]) + 1);
                }
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  
            int key = entry.getKey().intValue();
            int value = entry.getValue().intValue();
            
            // 有重复数字，所以要大于
            if(value >= Matrix.length) {
                return key;
            }
         }
         
         return 0;
    }
}