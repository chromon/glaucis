class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        if (name.length() == 0) {
            return true;
        }
        
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        
        int i = 1, j = 1;
        
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        
        return i == name.length();
    }
}