package code;

/**
 * 判断一个字串是否是回文？
 *
 * Created by Ellery on 2017/2/20.
 */

public class N01_04 {

    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();

        for (int i = 0, j = c.length - 1; i < j; i ++, j --) {
            if (c[i] != c[j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        N01_04 n = new N01_04();
        System.out.println(n.isPalindrome("ama"));
    }
}
