public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        //注意空指针和空集的区别，空指针返回[],空集返回[[]]
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            //List是更抽象的接口类，不能用于实例化，实例化用ArrayList
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        List<Integer> list = new ArrayList<>();
        helper(nums, list, results);
        return results;
    }
    
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> results) {
        //递归的出口
        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        //递归的拆解，题目声明无重复元素，所以要有一个去重的过程
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, list, results);
            list.remove(list.size() - 1);
        }
    }
}