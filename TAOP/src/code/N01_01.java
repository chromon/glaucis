package code;

/**
 * 旋转字符串
 *
 *      abcdef -> cdefab
 *
 * Created by Ellery on 2017/2/18.
 */

public class N01_01 {

    /**
     * 方法1：字符数组截取复制到新数组
     * @param s
     * @param n
     * @return
     */
    private String convertString(String s, int n) {

        char[] c = s.toCharArray();
        char[] t = new char[c.length];

        for (int i = n; i < c.length; i ++) {
            t[i - n] = c[i];
        }

        int m = c.length - n;
        for (int i = 0; i < n; i ++) {
            t[m] = c[i];
            m ++;
        }

        return String.valueOf(t);
    }

    /**
     * 字符翻转
     * @param c 待翻转字符数组
     * @param lo 起始位置
     * @param hi 结束位置
     */
    private void reverseString(char[] c, int lo, int hi) {
        while (lo < hi) {
            char t = c[lo];
            c[lo] = c[hi];
            c[hi] = t;

            lo ++;
            hi --;
        }
    }

    /**
     * 方法2：
     *      字符串（abcdef）旋转连接相当于前一部分子串翻转（ab -> ba）,
     *      与后一部分子串翻转（cdef -> fedc)，两个子串翻转之后的新的字符串（bafedc -> cdefab）再次翻转
     * @param s
     * @param n
     * @return
     */
    public String convertString2(String s, int n) {
        char[] c = s.toCharArray();
        this.reverseString(c, 0, n - 1);
        this.reverseString(c, n, c.length - 1);
        this.reverseString(c, 0, c.length - 1);

        return String.valueOf(c);
    }

    public static void main(String[] args) {
        N01_01 n = new N01_01();
        System.out.println(n.convertString("abcdef", 2));
        System.out.println(n.convertString2("abcdef", 2));
    }
}
