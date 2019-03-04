class Solution {
    /*public int[] twoSum(int[] numbers, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                if (numbers[i] < target - numbers[i]) {
                    res[0] = i + 1;
                    res[1] = map.get(target - numbers[i]) + 1;
                } else {
                    res[0] = map.get(target - numbers[i]) + 1;
                    res[1] = i + 1;
                }
                return res;
            } 
            map.put(numbers[i], i);
        }
        
        return res;
    }*/
    

    public int[] twoSum(int[] numbers, int target) {
        
        for (int i = 0, j = numbers.length - 1; i < j;) {
            if (numbers[i] + numbers[j] == target) {
                int[] res = {i + 1, j + 1};
                return res;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        
        return new int[2];
    }
}