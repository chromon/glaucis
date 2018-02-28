public class Solution {
    /**
     * @param a: a integer represent the length of one edge
     * @param b: a integer represent the length of one edge
     * @param c: a integer represent the length of one edge
     * @return: whether three edges can form a triangle
     */
    public boolean isValidTriangle(int a, int b, int c) {
        // write your code here
        if(a + b > c && a + c > b && b + c > a) {
            return true;
        }
        return false;
    }
}