package code;

/**
 * 给定一个字符串，求它的最长回文子串的长度。
 *
 * Created by Ellery on 2017/2/20.
 */

public class N01_05 {

    public int maxPalindrome(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
        int maxLen = 0;
        for (int i = 0; i < n; i ++) {  // i作为终点
            int j = i;    //j作为起点
            while (j >= 0) {
                if (s.charAt(j) == s.charAt(i) && (i - j <2 || pal[j+1][i-1])){
                    pal[j][i] = true;
                    maxLen = Math.max(maxLen, i - j + 1);
                }
                j --;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        N01_05 n = new N01_05();
        System.out.println(n.maxPalindrome("tattarrattat"));
    }
}
