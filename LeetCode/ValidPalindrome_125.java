class Solution {
    public boolean isPalindrome(String s) {
        /*
        *  数字：[0x30,0x39]（或十进制[48, 57]）
        *  小写字母：[0x61,0x7a]（或十进制[97, 122]）
        *  大写字母：[0x41,0x5a]（或十进制[65, 90]）
        */
        
        if (s == "") {
            return true;
        }
        
        s = s.toUpperCase();
        
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (!(Character.isDigit(s.charAt(i)) || Character.isUpperCase(s.charAt(i)))) {
                i++;
            } else if (!(Character.isDigit(s.charAt(j)) || Character.isUpperCase(s.charAt(j)))) {
                j--;
            } else {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        
        return true;
    }
}