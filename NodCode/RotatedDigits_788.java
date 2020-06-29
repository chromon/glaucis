class Solution {
    public int rotatedDigits(int N) {
        
        int sum = 0;
        
        for (int i = 1; i <= N; i++) {
            if (isGood(i)) {
                sum++;
            }
        }
        
        return sum;
    }
    
    private boolean isGood(int n) {
        Integer[] a1 = new Integer[]{2, 5, 6, 9, 0, 1, 8};
        Integer[] a2 = new Integer[]{2, 5, 6, 9};
        
        Set<Integer> set1 = new HashSet<>(Arrays.asList(a1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(a2));
        
        boolean flag = false;
        while (n > 0) {
            int tmp = n % 10;
            if (!set1.contains(tmp)) {
                return false;
            } else {
                if (set2.contains(tmp)) {
                    flag = true;
                }
            }
            
            n /= 10;
        }
        
        return flag;
    }
}