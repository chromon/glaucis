class Solution {
    public String[] findRelativeRanks(int[] nums) {
        
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        
        Arrays.sort(tmp);
        
        Map<Integer, String> map = new HashMap<>();
   
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                map.put(tmp[nums.length - 1], "Gold Medal");
            } else if (i == nums.length - 2) {
                map.put(tmp[nums.length - 2], "Silver Medal");
            } else if (i == nums.length - 3) {
                map.put(tmp[nums.length - 3], "Bronze Medal");
            } else {
                map.put(tmp[i], String.valueOf(nums.length - i));
            }
        }
        
        String[] res = new String[nums.length];
     
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums[i]);
        }
        
        return res;
    }
}