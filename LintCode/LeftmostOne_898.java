public class Solution {
    /**
     * @param arr: The 2-dimension array
     * @return: Return the column the leftmost one is located
     */
    public int getColumn(int[][] arr) {
        // Write your code here
        int pos = arr.length;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    if (pos > j) {
                        pos = j;
                    }
                    break;
                }
            }
        }
        
        return pos;
    }
}