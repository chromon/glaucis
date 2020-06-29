class Solution {
    /*public int majorityElement(int[] nums) {
        
        // 40 m 48 MB
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        for (Integer key: map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        
        return 0;
    }*/
    
    public int majorityElement(int[] nums) {
        // 7 ms	49.8 MB
        // 摩尔投票算法是基于这个事实：每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），
        // 最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个。
        int count = 1;
		int maj = nums[0];
        
		for (int i = 1; i < nums.length; i++) {
			if (maj == nums[i])
				count++;
			else {
				count--;
				if (count == 0) {
					maj = nums[i + 1];
				}
			}
		}
        
		return maj;
    }
}