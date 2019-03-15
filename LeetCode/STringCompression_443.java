class Solution {
    public int compress(char[] chars) {
        
        int i = 0;
        int count = 0;
        
        for (int j = 0; j < chars.length; j++) {
            count++;
            
            if (j == chars.length - 1 || chars[j] != chars[j + 1]) {
                chars[i] = chars[j];
                i++;
                
                if (count > 1) {
                    char[] ch = String.valueOf(count).toCharArray();
                    for (char c: ch) {
                        chars[i] = c;
                        i++;
                    }
                }
                
                count = 0;
            }
        }
        
        return i;
    }
}