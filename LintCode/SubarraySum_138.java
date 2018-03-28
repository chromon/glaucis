public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        
        // 记录每一位下标和相加到当前位的和的映射, 若和重复出现, 则相应的区间内的和必为0
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if(! map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                list.add(map.get(sum) + 1);
                list.add(i);
            }
        }
        
        return list;
    }
}