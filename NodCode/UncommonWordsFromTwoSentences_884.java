class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        
        String str = A + " " + B;
        Map<String, Integer> map = new HashMap<>();
        
        for (String s: str.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for (String key: map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }
        }
        
        return list.toArray(new String[list.size()]);
    }
}