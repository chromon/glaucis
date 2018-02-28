public class Solution {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        
        String sum = "";
        
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        
        return Integer.parseInt(sum);
    }
}