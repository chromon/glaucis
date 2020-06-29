class Solution {
    public int repeatedNTimes(int[] A) {
        
        Set<Integer> set = new HashSet<>();
        
        for (int i : A) {
            if (set.contains(i)) {
                return i;
            } else {
                set.add(i);
            }
        }
        
        return 0;
    }
}