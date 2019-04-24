class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        char[] c = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        int max = 0;
        int j = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(c[i])) {
                j = Math.max(j, map.get(c[i]) + 1);
            }
            map.put(c[i], i);
            max = Math.max(max, i - j + 1);
        }
        
        return max;
    }
}