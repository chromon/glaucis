class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        int min = Integer.MAX_VALUE;
        
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                
                if (i + j < min) {
                    min = i + j;
                    list = new ArrayList<>();
                    list.add(list2[i]);
                } else if (i + j == min) {
                    list.add(list2[i]);
                }
            }
        }
        
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}