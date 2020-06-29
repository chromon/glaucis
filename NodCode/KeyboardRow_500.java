class Solution {
    public String[] findWords(String[] words) {
        
        String s = "qwertyuiopasdfghjklzxcvbnm";
        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int tmp = 0;
        
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                tmp = 1;
            } else if (s.charAt(i) == 'z') {
                tmp = 2;
            }
            map.put(s.charAt(i), tmp);
        }
        
        for (int i = 0; i < words.length; i++) {
            int line = map.get(Character.toLowerCase(words[i].charAt(0)));
            boolean flag = false;
            
            for (int j = 0; j < words[i].length(); j++) {
                if (map.get(Character.toLowerCase(words[i].charAt(j))) != line) {
                    flag = true;
                    break;
                } 
            }
            
            if (!flag) {
                list.add(words[i]);
            }
        }
        
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}