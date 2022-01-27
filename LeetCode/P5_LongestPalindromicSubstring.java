/*
5. Longest Palindromic Substring
Medium


Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution {
    
    /*
        动态规划

        一个长度严格大于 2 的回文去掉头尾字符以后，剩下的部分依然是回文。
        反之，如果一个字符串头尾两个字符都不相等，那么这个字符串一定不是回文。

        dp[i][j] 表示：子串 s[i..j] 是否为回文子串， s[i..j] 定义为左闭右闭区间。
        
        dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
        
        dp[i + 1][j - 1] 需要考虑特殊情况：
        
        如果去掉 s[i..j] 头尾两个字符子串 s[i + 1..j - 1] 的长度严格小于 2（不构成区间），
        即 j - 1 - (i + 1) + 1 < 2 时，整理得 j - i < 3，
        此时 s[i..j] 是否是回文只取决于 s[i] 与 s[j] 是否相等。
        
        结论也比较直观：j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j]s[i..j] 的长度等于 2 
        或者等于 3 的时候，s[i..j] 是否是回文由 s[i] 与 s[j] 是否相等决定。

        由于 s[i..j] 表示 s 的一个子串，因此 i 和 j 的关系是 i <= j,
    */
    /*
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文
                // 此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        
        return s.substring(begin, begin + maxLen);
    }
    */
    
    /*
        中心扩散法（效率最高）
        
        基本思想是：遍历每一个下标，以该下标为中心，利用「回文串」中心对称的特点，
        向两边扩散，直到不是一个回文串。
        
        回文串在长度为奇数和偶数的时候，「回文中心」的形态不一样：

        - 奇数回文串的「中心」是一个具体的字符；
        - 偶数回文串的「中心」是位于中间的两个字符（也可称之为两个字符的「空隙」）。
        
        规定：
        
        - 如果传入重合的下标，进行中心扩散，此时得到的回文子串的长度是奇数；
        - 如果传入相邻的下标，进行中心扩散，此时得到的回文子串的长度是偶数。
    */
    
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = centerLen(s, i, i);
            int len2 = centerLen(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private int centerLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    
    /*
        最长的回文子串可以表示为 s 与 s 的逆序字符串间的最长公共子串。
        
        最长公共子串：
        
        - 把两个字符串分别以行和列组成一个二维矩阵。
        - 比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为 1，否则设置为 0。
        - 通过查找出值为 1 的最长对角线就能找到最长公共子串。
        
        例：babad 与逆序字符串 dabab
        
            b a b a d
          d 0 0 0 0 1
          a 0 1 0 1 0
          b 1 0 1 0 0
          a 0 1 0 1 0
          b 1 0 1 0 0
          
        最长对角线为 3 个 1，分别是 bab 和 aba
          
        在计算二维矩阵的某个值时，可以顺便计算出来当前最长的公共子串的长度，
        即某个二维矩阵元素的值由 arr[i][j] = 1 演变为 arr[i][j] = 1 +arr[i-1][j-1]
        这样就避免了后续查找对角线长度的操作。
        
        s = "abc435cba"，t = "abc534cba"，最长公共子串是 "abc" 和 "cba"
        最长公共子串并不是回文串。
        需要判断该字符串倒置前的下标和当前的字符串下标是不是匹配。
        
        s = "caba"，t = "abac" ，t 中 aba 的下标是 0 1 2 ，倒置前是 3 2 1，
        和 S 中 aba 的下标符合，所以 aba 就是需要的。当然不需要每个字符都判断，
        只需要判断末尾字符即可。
    */
    /*
    public String longestPalindrome(String s) {
        String src = s;
        String rev = new StringBuilder(s).reverse().toString();
        int[][] arr = new int[s.length()][s.length()];
        
        int maxLen = 0;
        int maxEnd = 0;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (src.charAt(i) == rev.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                
                if (arr[i][j] > maxLen) {
                    int beforeRev = s.length() - 1 - j;
                    // 判断下标是否对应
                    if (beforeRev + arr[i][j] - 1 == i) { 
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
    */
    
    /*
    // Time Limit Exceeded
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalind(sub) && sub.length() > max) {
                    max = sub.length();
                    res = sub;
                }
            }
        }
        return res;
    }
    
    private boolean isPalind(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    */
}