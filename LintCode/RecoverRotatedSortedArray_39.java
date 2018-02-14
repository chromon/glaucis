public class Solution {
    /*
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int i = 0;
        for(i = 0; i < nums.size() - 1; i ++) {
            if(nums.get(i) > nums.get(i + 1)) {
                break;
            }
        }
        
        List<Integer> tmp = new ArrayList<>();
        
        int k = 0;
        Iterator<Integer> it = nums.iterator();
        while(it.hasNext() && k <= i) {
            int t = it.next();
            tmp.add(t);
            it.remove();
            k ++;   
        }
        
        for(int j: tmp) {
            nums.add(j);
        }
    }
}