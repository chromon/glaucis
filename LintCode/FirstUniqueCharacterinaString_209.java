public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        
        char[] c = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < c.length; i ++) {
            if(! map.containsKey(c[i])) {
                map.put(c[i], 1);
            } else {
                map.put(c[i], map.get(c[i]) + 1);
            }
        }
        
        char t = '\0';
        for(int i = 0; i < c.length; i ++) {
            if(map.get(c[i]) == 1) {
                t = c[i];
                break;
            }
        }
        
        return t;
    }
}