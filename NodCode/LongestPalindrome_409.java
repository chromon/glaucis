class Solution {
    public int longestPalindrome(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else if (map.get(s.charAt(i)) == 1) {
                map.remove(s.charAt(i));
                len += 2;
            }
        }
        
        if (!map.isEmpty()) {
            len++;
        }
        
        return len;
    }
}