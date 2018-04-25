public class Solution {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();
        
        for (String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            
            if (! map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            }
        }
        
        for (List<String> value: map.values()) {
            res.add(value);
        }
        
        return res;
    }
}