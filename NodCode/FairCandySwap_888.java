class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        // sa - x + y = sb - y + x
        // x = (sa - sb) / 2 + y
        int sa = 0, sb = 0;
        
        for (int i : A) {
            sa += i;
        }
        
        for (int i : B) {
            sb += i;
        }
        
        int tmp = (sb - sa) / 2;
        
        Set<Integer> set = new HashSet<>();
        
        for (int i: B) {
            set.add(i);
        }
        
        for (int i : A) {
            if (set.contains(i + tmp)) {
                return new int[] {i, i + tmp};
            }
        }
        
        return null;
    }
}