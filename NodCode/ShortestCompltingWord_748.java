class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.toLowerCase().charAt(i);
            if (c >= 97 && c <= 123) {
                map.put(c - 97, map.getOrDefault(c - 97, 0) + 1);
            }
        }
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for (String word: words) {
            int[] tmp = new int[26];
            
            for (char c: word.toCharArray()) {
                if (c >= 97 && c <= 123) {
                    tmp[c - 97]++;
                }
            }
            
            boolean flag = true;
            for (int key: map.keySet()) {
                if (tmp[key] < map.get(key)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return word;
            }
        }
        
        return null;
    }
}