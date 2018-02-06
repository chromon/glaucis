public class Solution {
    /*
     * @param s: A string
     * @return: the length of last word
     */
    public int lengthOfLastWord(String s) {
        // write your code here
        
        if(s == "" || s == null) {
            return 0;
        }
        
        char[] c = s.trim().toCharArray();
        int k = 0;
        
        for(int i = c.length - 1; i >= 0; i --) {
            if(c[i] == ' ') {
                break;
            }
            k ++;
        }
        return k;
    }
}