public class Solution {
    /*
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        // write your code here
        
        char[] c = s.toCharArray();
        
        for(int i = 0; i < c.length; i ++) {
            boolean flag = false;
            
            for(int j = 0; j < c.length; j ++) {
                if(i != j && c[i] == c[j]) {
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                return i;
            }
        }
        return -1;
    }
}