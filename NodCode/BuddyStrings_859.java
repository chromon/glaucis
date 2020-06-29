class Solution {
    public boolean buddyStrings(String A, String B) {
        
        /*
            字符串长度不相等, 直接返回false
            字符串相等的时候, 只要有重复的元素就返回true
            A, B字符串有不相等的两个地方, 需要查看它们交换后是否相等即可.
        */
        
        if (A.length() != B.length()) {
            return false;
        }
        
        if (A.length() < 2) {
            return false;
        }
        
        if (A.equals(B)) {
            for (char c: A.toCharArray()) {
                if (A.indexOf(c) != A.lastIndexOf(c)) {
                    return true;
                }
            }
            return false;
        }
        
        String sa = "", sb = "";
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                sa += String.valueOf(A.charAt(i));
                sb = B.charAt(i) + sb;
            }
        }
        
        if (sa.length() != 2) {
            return false;
        }
        
        return sa.equals(sb);
    }
}