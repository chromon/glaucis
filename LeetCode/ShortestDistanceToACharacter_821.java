class Solution {
    public int[] shortestToChar(String S, char C) {
        
        int[] res = new int[S.length()];
        int pre = -1;
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                int j = i - 1;
                for (; j > pre; j--) {
                    res[j] = (pre == -1) ? i - j : Math.min(i - j, j - pre);
                }
                pre = i;
            }
        }
        
        for (int i = pre + 1; i < S.length(); i++) {
            res[i] = i - pre;
        }
        
        return res;
    }
}