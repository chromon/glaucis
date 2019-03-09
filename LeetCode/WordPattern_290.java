class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        char[] c = pattern.toCharArray();
        String[] s = str.split(" ");
        
        if (c.length != s.length) {
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < c.length; i++) {
            if (!map.containsKey(c[i])) {
                if (!map.containsValue(s[i])) {
                    map.put(c[i], s[i]);
                } else {
                    return false;
                }
            } else {
                if (!map.get(c[i]).equals(s[i])) {
                    return false;
                }
            }
        }
        
        return true;
    }
}