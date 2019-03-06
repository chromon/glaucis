class Solution {
    public boolean isIsomorphic(String s, String t) {
        // 43 ms	45.5 MB
        if (s.length() != t.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        
        s = mappingString(s.toCharArray());
        t = mappingString(t.toCharArray());
        
        return s.equals(t);
    }
    
    public String mappingString(char[] c) {
        
        Map<Character, Integer> map = new HashMap<>();
        StringBuffer res = new StringBuffer();
        int tmp = 0;
        
        for (int i = 0; i < c.length; i++) {
            if (!map.containsKey(c[i])) {
                map.put(c[i], tmp);
                tmp++;
                res.append(map.get(c[i]));
            } else {
                res.append(map.get(c[i]));
            }
        }
        
        return res.toString();
    }
}