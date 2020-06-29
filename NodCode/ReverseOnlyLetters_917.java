class Solution {
    public String reverseOnlyLetters(String S) {
        
        if (S == null || S.length() == 0) {
            return S;
        }
        
        char[] c = S.toCharArray();
        
        int i = 0, j = c.length - 1;
        
        while (i < j) {
            if (c[i] < 'A' || (c[i] > 'Z' && c[i] < 'a') || c[i] > 'z') {
                i++;
            }
            
            if (c[j] < 'A' || (c[j] > 'Z' && c[j] < 'a') || c[j] > 'z') {
                j--;
            }
            
            if (((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')) 
                    && ((c[j] >= 'a' && c[j] <= 'z') || (c[j] >= 'A' && c[j] <= 'Z'))) {
                char tmp = c[i];
                c[i] = c[j];
                c[j] = tmp;
                
                i++;
                j--;
            }
        }
        
        return String.valueOf(c);
    }
}