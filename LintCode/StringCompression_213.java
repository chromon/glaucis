public class Solution {
    /**
     * @param str: a string
     * @return: a compressed string
     */
    public String compress(String str) {
        // write your code here
        
        if(str.equals("")) {
            return "";
        }
        
        char[] c = str.toCharArray();
        char tmp = c[0];
        int count = 0;
        String s = "";
        
        for(int i = 0; i < c.length; i ++) {
            if(c[i] == tmp) {
                count ++;
            } else {
                s += String.valueOf(tmp) + count;
                
                tmp = c[i];
                count = 1;
            }
        }
        
        s += String.valueOf(tmp) + count;
    
        return str.length() > s.length()? s: str;
    }
}