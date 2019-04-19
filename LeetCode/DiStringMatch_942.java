class Solution {
    public int[] diStringMatch(String S) {
        
        int res[] = new int[S.length() + 1];
        int i = 0, j = S.length();
        int now = 0;
        int temp = 0;
        
        while(now < S.length()){
            res[now++] = S.charAt(temp++) == 'I' ? i++ : j--;
        }
        
        res[now] = i;
        
        return res;
    }
}