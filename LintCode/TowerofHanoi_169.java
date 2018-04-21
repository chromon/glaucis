public class Solution {
    /**
     * @param n: the number of disks
     * @return: the order of moves
     */
    List<String> res = new ArrayList<>();
    public List<String> towerOfHanoi(int n) {
        // write your code here
        move(n, "A", "B", "C");
        return res;
        
    }
    
    public void move(int n, String from, String buffer, String to) {
        if (n == 1) {
            res.add("from " + from + " to " + to);
        } else {
            move(n-1, from, to, buffer);
            move(1, from, buffer, to);
            move(n-1, buffer, from, to);
        }
    }
}