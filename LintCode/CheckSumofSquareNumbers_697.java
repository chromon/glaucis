public class Solution {
    /**
     * @param num: the given number
     * @return: whether whether there're two integers
     */
    public boolean checkSumOfSquareNumbers(int num) {
        // write your code here
        if(num < 0){
            return false;
        }
        
        int i = 0, j = (int) Math.sqrt(num);
        while(i <= j){
            if(i * i + j * j < num){
                i ++;
            } else if(i * i + j * j == num){
                return true;
            } else {
                j --;
            }
        }
        
        return false;
    }
}