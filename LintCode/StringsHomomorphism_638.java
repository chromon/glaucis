public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // write your code here
        
        // char[] sc = s.toCharArray();
        // char[] tc = t.toCharArray();
        
        // Map<Character, Integer> maps = new HashMap<>();
        // Map<Character, Integer> mapt = new HashMap<>();
        
        // for(int i = 0; i < sc.length; i ++) {
        //     if(! maps.containsKey(sc[i])) {
        //         maps.put(sc[i], 1);
        //     } else {
        //         maps.put(sc[i], maps.get(sc[i]).intValue() + 1);
        //     }
            
        //     if(! mapt.containsKey(tc[i])) {
        //         mapt.put(tc[i], 1);
        //     } else {
        //         mapt.put(tc[i], mapt.get(tc[i]).intValue() + 1);
        //     }
            
        //     if(maps.get(sc[i]).intValue() != mapt.get(tc[i]).intValue()) {
        //         return false;
        //     }
        // }
            
        // return true;
        
        /*
            key 和 value 分别对应，s 为 key t 为 value，t 为 key s 为 value，
            应同时对应
        */
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        
        for(int i = 0; i < sc.length; i ++) {
            if(! map.containsKey(sc[i])) {
                map.put(sc[i], tc[i]);
            } else {
                if(map.get(sc[i]) != tc[i]) {
                    return false;
                }
            }
            
            if(! map2.containsKey(tc[i])) {
                map2.put(tc[i], sc[i]);
            } else {
                if(map2.get(tc[i]) != sc[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}