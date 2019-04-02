class Solution {
    public String toLowerCase(String str) {
        
        char[] c = str.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 65 && c[i] <= 90) {
                c[i] += 32;
            }
        }
        
        return String.valueOf(c);
    }
}