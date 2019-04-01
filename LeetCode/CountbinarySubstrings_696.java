class Solution {
    public int countBinarySubstrings(String s) {
        
        // 用last来记录之前一种数字的个数， cur来记录当前数字的个数； 
        // 当last >= cur的时候， res ++
        
        int last = 0, cur = 1;
        int res = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                last = cur;
                cur = 1;
            }
            
            if (last >= cur) {
                res++;
            }
        }
        
        return res;
    }
}