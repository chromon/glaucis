class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        
        int[] res = new int[set2.size()];
        int t = 0;
        
        Iterator<Integer> it = set2.iterator();
        while (it.hasNext()) {
            res[t++] = it.next();
        }
        
        return res;
    }
}