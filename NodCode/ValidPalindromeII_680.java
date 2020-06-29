class Solution {
    public boolean validPalindrome(String s) {
        
        /*
            利用双指针，一个指向起点，一个指向结束，若两端字符串相同，则同时向中间移动，若不相同，则判断两种情况：第一种只移动左边（相当于删除左边的一个字符），然后继续判断，另一种是只移动右边（相当于删除右边的一个字符），然后继续判断。
        */
        
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (isValid(s, i + 1, j) || isValid(s, i, j - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}