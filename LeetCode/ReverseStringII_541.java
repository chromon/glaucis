class Solution {
    public String reverseStr(String s, int k) {
        
        boolean flag = true;
        
        for (int i = 0; i < s.length(); i += k) {
            if (flag) {
                if (i + k - 1 >= s.length()) {
                    s = reverseK(s, i, s.length() - 1);
                } else {
                    s = reverseK(s, i, i + k - 1);
                }
            }
            flag = !flag;
        }
        
        return s;
    }
    
    private String reverseK(String s, int i, int j) {
        char[] c = s.toCharArray();
        
        for (; i < j; i++, j--) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
        return String.valueOf(c);
    }
}