public class Solution {
    /**
     * @param dic: the n strings
     * @param target: the target string
     * @return: The ans
     */
    public int theLongestCommonPrefix(List<String> dic, String target) {
        // write your code here
        
        char[] t = target.toCharArray(); 
        
        int len = 0;
        int tempLen = 0;
        
        for(String s: dic) {
            
            if(tempLen > len) {
                len = tempLen;
            }
            
            tempLen = 0;
            char[] c = s.toCharArray();
            int maxLen = t.length < c.length? t.length: c.length;
            
            for(int i = 0; i < maxLen; i ++) {
                if(c[i] == t[i]) {
                    tempLen ++;
                }
            }
        }
        return len;
    }
}