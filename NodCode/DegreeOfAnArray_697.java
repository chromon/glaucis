class Solution {
    public int findShortestSubArray(int[] nums) {
        
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        
        int degree = 0;
        int len = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            countMap.putIfAbsent(nums[i], 0);
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
            startMap.putIfAbsent(nums[i], -1);
            
            if (startMap.get(nums[i]) == -1) {
                startMap.put(nums[i], i);
            }
            
            if (countMap.get(nums[i]) == degree) {
                len = Math.min(len, i - startMap.get(nums[i]) + 1);
            } else if (countMap.get(nums[i]) > degree) {
                degree = countMap.get(nums[i]);
                len = i - startMap.get(nums[i]) + 1;
            }
        }
        
        return len;
    }
}