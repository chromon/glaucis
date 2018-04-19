public class Solution {
    /**
     * @param str: String
     * @return: String
     */
    public String convertPalindrome(String str) {

        int j = 0;
        // 找到第一个使他不回文的位置
        for (int i = str.length() - 1; i >= 0; i--) {
           if (str.charAt(i) == str.charAt(j)) { 
               j += 1; 
           }
        }

        if (j == str.length()) {  //本身是回文
            return str; 
        }

        // 后缀不能够匹配的字符串
        String suffix = str.substring(j);
        // 前面补充prefix让他和suffix回文匹配
        String prefix = new StringBuilder(suffix).reverse().toString(); 
        // 递归调用找 [0, j]要最少可以补充多少个字符让他回文
        String mid = convertPalindrome(str.substring(0, j)); 

        String ans = prefix + mid  + suffix;

        return  ans;

    }
    
    // 91% Memory Limit Exceeded
    // public String convertPalindrome(String str) {
    //     // Write your code here
        
    //     if (isPalindrome(str)) {
    //         return str;
    //     }
        
    //     StringBuilder start = new StringBuilder();
    //     for (int i = str.length() - 1; i >= 0; i--) {
    //         start.append(str.charAt(i));
            
    //         if(isPalindrome(start.toString() + str)) {
    //             break;
    //         }
    //     }
        
    //     return start.append(str).toString();
    // }
    
    // public boolean isPalindrome(String str) {
        
    //     for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
    //         if (str.charAt(i) != str.charAt(j)) {
    //             return false;
    //         }
    //     }
        
    //     return true;
    // }
}