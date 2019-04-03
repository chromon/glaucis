class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            
            boolean flag = true;
            
            int tmp = i;
            
            while (tmp > 0) {
                int a = tmp % 10;
                if (a == 0 || i % a != 0) {
                    flag = false;
                    break;
                }
                tmp /= 10;
            }
            
            if (flag) {
                res.add(i);
            }
        }
        
        return res;
    }
}