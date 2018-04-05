public class Solution {
    /**
     * @param s1: the 1st string
     * @param s2: the 2nd string
     * @return: uncommon characters of given strings
     */
    public String concatenetedString(String s1, String s2) {
        // write your code here
        
        if(s2.equals("")) {
            return s1;
        }
        
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        for(int i = 0; i < c2.length; i ++) {
            if(! set2.contains(c2[i])) {
                // s2 包含部分
                set2.add(c2[i]);
            }
        }
        
        String s = "";
        for(int i = 0; i < c1.length; i ++) {
            if(! set2.contains(c1[i])) {
                // s1 中有 s2 没有的
                s += c1[i];
            } else {
                if(! set.contains(c1[i])) {
                    // 公共部分
                    set.add(c1[i]);
                }
            }
        }
        
        for(int i = 0; i < c2.length; i ++) {
            if(! set.contains(c2[i])) {
                // s2 中有 s1 没有的
                s += c2[i];
            }
        }
        
        return s;
    }
}