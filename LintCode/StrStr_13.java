public class Solution {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // write your code here
        
        if(source == null || target == null) {
            return -1;
        }
        
        if(source.equals("") && target.equals("")) {
            return 0;
        }
        
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        
        int slen = source.length();
        int tlen = target.length();
        
        for(int i = 0; i <= slen - tlen; i ++) {
            int tmp = 1;
            for(int j = 0; j < tlen; j ++) {
                if(s[i+j] != t[j]) {
                    tmp = 0;
                    break;
                }
            }
        
            if(tmp == 1) {
                return i;
            }
        }
        return -1;
    }
}