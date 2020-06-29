class Solution {
    public char findTheDifference(String s, String t) {
        
        char res = t.charAt(t.length() - 1);
        
        /*
            0 ^ 3 = 3;
            3 ^ 3 = 0;
            
            1 ^ 1 ^ 2 ^ 2 ^ 3 = 3;
        */
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        
        return res;
    }
}