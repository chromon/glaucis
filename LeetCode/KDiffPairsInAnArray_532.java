class Solution {
    public int findPairs(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        if (k < 0) {
            return 0;
        }
        
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        
        for (int i : map.keySet()) {
            if (k == 0) {
                if (map.get(i) > 1) {
                    count++;
                }
            } else if (map.containsKey(i + k)) {
                count++;
            }
        }
        
        return count;
        
    }
}