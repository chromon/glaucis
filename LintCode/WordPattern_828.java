public class Solution {
    /**
     * @param pattern: a string, denote pattern string
     * @param str: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String str) {
        // write your code here
        
        char[] c = pattern.toCharArray();
        String[] s = str.split(" ");
        
        if(c.length != s.length) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        
        for(int i = 0; i < c.length; i ++) {
            if(! map.containsKey(c[i])) {
                if(! map.containsValue(s[i])) {
                    map.put(c[i], s[i]);
                } else {
                    return false;
                }
            } else {
                if(!map.get(c[i]).equals(s[i])) {
                    return false;
                }
            }
        }
        
        return true;
    }
}