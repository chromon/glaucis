class Solution {
    public int findLHS(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        
        int max = 0;
        
        for (int i: map.keySet()) {
            if (map.containsKey(i + 1)) {
                int tmp = map.get(i) + map.get(i + 1);
                max = Math.max(max, tmp);
            }
        }
        
        return max;
    }
}