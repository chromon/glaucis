public class Solution {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String removeDuplicateLetters(String s) {
        // write your code here
        int[] index = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i + 1;
        }
        
        int start = 0;
        int cur = findMinIndex(index); 
        while (cur >= 0) {
            int chosen = findMinChar(s, start, cur, index); 
            start = chosen + 1;
            index[s.charAt(chosen) - 'a'] = 0;
            sb.append(s.charAt(chosen));
            cur = findMinIndex(index);
        }
        
        return sb.toString();
    }
    
    private int findMinIndex(int[] index) {
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < 26; i++) {
            if (index[i] > 0 && min > index[i]) {
                min = index[i];
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min - 1;
        }
    }
    
    private int findMinChar(String s, int start, int end, int[] index) {
        int min = -1;
        char c = '{';
        
        for (int i = start; i <= end; i++) {
            if (index[s.charAt(i) - 'a'] > 0 && c > s.charAt(i)) {
                c = s.charAt(i);
                min = i;
            }
        }
        
        return min;
    }
}