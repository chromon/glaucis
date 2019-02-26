class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        
        int i = 0, j = 0;
        
        for (; i < haystack.length(); i++) {
            if (j == needle.length()) {
                return i - needle.length();
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        
        if (j == needle.length()) {
            return i - needle.length();
        }
        
        return -1;
    }
}