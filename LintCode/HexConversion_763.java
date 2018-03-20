public class Solution {
    /**
     * @param n: a decimal number
     * @param k: a Integer represent base-k
     * @return: a base-k number
     */
    public String hexConversion(int n, int k) {
        // write your code here
        
        // String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        String result = "";
        
        while(n != 0) {
            int i = n % k;
            char ch = array[i];
            stack.add(ch);
            n /= k;
        }
        
        while(! stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result.length() == 0? "0": result;
    }
}