class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        for (int i = 0; i < letters.length; i++) {
            char c = letters[i];
            
            if (c > target) {
                return c;
            }
        }
        
        target = '\0';
        for (char c: letters) {
            if (c > target) {
                return c;
            }
        }
        
        return '\0';
    }
}