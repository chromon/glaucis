class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        
        int[] res = {1, 0};
        int sum = 0;
        
        for (int i = 0; i < S.length(); i++) {
            sum += widths[S.charAt(i) - 'a'];
            if (sum > 100) {
                res[0]++;
                // 字符不能被拆分为两行
                sum = 0;
                i--;
            }
        }
        res[1] = sum;
        
        return res;
    }
}