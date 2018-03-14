public class Solution {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        
        if(str.length == 0) {
            return;
        }
        
        if(offset > 0) {
            
            // 去掉重复计算
            if(offset > str.length) {
                offset = offset % str.length;
            }
            
            for(int t = 0; t < offset; t ++) {
                char c = str[str.length - 1];
                
                for(int i = str.length - 2; i >= 0; i --) {
                    str[i + 1] = str[i];
                }
                str[0] = c;
            }
        }
    }
}