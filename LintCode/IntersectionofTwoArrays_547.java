public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        
        for(int i: nums1) {
            nums1Set.add(i);
        }
        
        for(int j: nums2) {
            if(nums1Set.contains(j)) {
                nums2Set.add(j);
            }
        }
        
        Iterator<Integer> iterator = nums2Set.iterator(); 
        int[] result = new int[nums2Set.size()]; 
        int m = 0; 
        
        while(iterator.hasNext()) { 
            result[m ++] = iterator.next(); 
        }
        
        return result;
    }
};