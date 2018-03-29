public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        // Map 里面 key 是元素的值，value 是元素原来的下标。然后再从头开始遍历数组，在 Map 中找 target = sum - arr[i] 的元素，若存在则返回，否则直至 i = len - 1 说明没有解
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        for(int i = 0; i < numbers.length; i ++) {
            
            if(map.containsKey(target - numbers[i])) {
                
                int a = map.get(target - numbers[i]);
                int b = i;
                
                result[0] = a;
                result[1] = b;
                
                return result;
            }
            
            map.put(numbers[i], i);
        }
        
        return result;
    }
}