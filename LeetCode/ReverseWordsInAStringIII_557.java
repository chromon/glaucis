class Solution {
    public String reverseWords(String s) {
        String[] sa = s.split(" ");
        
        for (int i = 0; i < sa.length; i++) {
            sa[i] = reverse(sa[i]);
        }
        
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        
        for (int i = 0; i < sa.length; i++) {
            sbf.append(tmp);
            sbf.append(sa[i]);
            tmp = " ";
        }
        
        return sbf.toString();
    }
    
    private String reverse(String s) {
        char[] c = s.toCharArray();
        
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
        
        return String.valueOf(c);
    }
}