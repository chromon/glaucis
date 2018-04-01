public class Solution {
    /**
     * @param nums: the num arrays 
     * @return: the num arrays after rearranging
     */
    public int[] rearrange(int[] nums) {
        // Write your code here 
        shellSort(nums);
        
        int[] r = new int[nums.length];
        
        int t = 0;
        for(int i = 0; i < nums.length; i +=2) {
            r[i] = nums[t];
            t ++;
        }
        
        for(int i = 1; i < nums.length; i += 2) {
            r[i] = nums[t];
            t ++;
        }
        
        return r;
    }
    
    public static void shellSort(int[] array){
        int j;
        for(int gap = array.length/2; gap > 0; gap /= 2){
            //定义一个增长序列，即分割数组的增量,d1=N/2   dk=(d(k-1))/2
            for(int i = gap; i < array.length; i ++){
                int tmp = array[i];
                for(j = i; j >= gap && tmp < array[j - gap]; j -= gap){
                    //将相距为Dk的元素进行排序
                    array[j] = array[j - gap];
                }
                array[j] = tmp;
            }
        }
    }
}