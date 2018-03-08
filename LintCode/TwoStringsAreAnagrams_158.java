public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        
        if(s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> maps = new HashMap<Character, Integer>();
        Map<Character, Integer> mapt = new HashMap<Character, Integer>();
        
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        for(int i = 0; i < sc.length; i ++) {
            if(maps.containsKey(sc[i])) {
                maps.put(sc[i], maps.get(sc[i]) + 1);
            } else {
                maps.put(sc[i], 1);
            }
            
            if(mapt.containsKey(tc[i])) {
                mapt.put(tc[i], mapt.get(tc[i]) + 1);
            } else {
                mapt.put(tc[i], 1);
            }
        }
        
        for(int i = 0; i < sc.length; i ++) {
            if(maps.get(sc[i]) != mapt.get(sc[i])) {
                return false;
            }
        }
        
        return true;
    }
}