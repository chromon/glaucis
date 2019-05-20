/*
思路
1. 先把数组排序
2. 从小到大遍历这个数组，每次取一个元素，将这个元素的相反数设为target
3. 在每次遍历中，使用双指针对当前元素的后面的所有元素进行处理，找到两个元素的和为target，这样，三个元素的和就是 0
4. 双指针的具体处理方式为：头尾各一个指针，每次判断两个指针所指的元素的和与target的大小，如果和小了，左指针右移；如果和大了，右指针左移，直到两个指针相遇
注意
1. 在第 2 条中，遍历数组的次数不是整个数组的长度，只需要遍历至倒数第 3 个元素，因为是考察 3 个元素的和
2. 因为不能有重复的结果，所以前后两次遍历取的元素如果相等，要采取跳过的操作
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums.length < 3) {
            return res;
        }
                
        Arrays.sort(nums);
        
        for (int t = 0; t < nums.length - 2; t++) {
            
            if (t > 0 && nums[t] == nums[t - 1]) {
                continue;
            }
            
            int target = -nums[t];
            int i = t + 1;
            int j = nums.length - 1;
            
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    res.add(Arrays.asList(nums[t], nums[i], nums[j]));
                    i++;
                    j--;
                    
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j + 1]) {
                        j--;
                    }
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        
        return res;
    }
}