public class Solution {
    /**
     * @param s: The data stream
     * @return: Return the judgement stream
     */
    public int[] getStream(String s) {
        // Write your code here
        
        // 取得是当前数据流的“排列”，即不一定是按顺序的
        // int[] res = new int[s.length()];
        
        // for(int i = 0, j = 0; j < s.length(); j ++) {
        //     if(isPalindrome(s.substring(i, j + 1))) {
        //         res[j] = 1;
        //     } else {
        //         res[j] = 0;
        //     }
        // }
        
        // return res;
        
        int [] ans = new int[s.length()];
        int [] alphabet = new int[26];
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (alphabet[c - 'a'] % 2 == 1) {
                cnt--;
                alphabet[c - 'a']++;
            } else {
                cnt++;
                alphabet[c - 'a']++;
            }
            if (cnt > 1) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
        }
        
        return ans;
    }
    
    // public boolean isPalindrome(String s) {
        
    //     for(int i = 0, j = s.length() - 1; i < j; i ++, j --) {
    //         if(s.charAt(i) != s.charAt(j)) {
    //             return false;
    //         }
    //     }
        
    //     return true;
    // }
}