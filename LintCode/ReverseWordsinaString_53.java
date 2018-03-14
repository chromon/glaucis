public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        
        if(s.equals("")) {
            return "";
        }
        
        String[] c = s.trim().split(" ");
        String str = "";
        
        for(int i = c.length - 1; i >= 0; i --) {
        
            str += c[i] + " ";
        }
        
        return str.trim();
    }
}