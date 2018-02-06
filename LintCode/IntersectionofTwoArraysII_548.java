public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        
        List<Integer> list = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i ++;
                j ++;
            } else if(nums1[i] > nums2[j]) {
                j ++;
            } else {
                i ++;
            }
        }
        
        int[] a = new int[list.size()];
        for(int k = 0; k < list.size(); k ++) {
            a[k] = list.get(k);
        }
        
        return a;
    }
};