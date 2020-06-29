class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] str = paragraph.split("\\s+");
        
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        
        for (int i = 0; i < str.length; i++) {
            if (!set.contains(str[i])) {
                map.put(str[i], map.getOrDefault(str[i], 0) + 1);
            }
        }
        
        String res = "";
        int max = -1;
        
        for(String key: map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }
        
        
        return res;
    }
}