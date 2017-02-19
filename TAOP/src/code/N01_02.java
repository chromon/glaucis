package code;

/**
 * 给定两个分别由字母组成的字符串A和字符串B，
 * 字符串B的长度比字符串A短。请问，
 * 如何最快地判断字符串B中所有字母是否都在字符串A里？
 *
 * Created by Ellery on 2017/2/19.
 */

public class N01_02 {

    public boolean stringContain(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        for (int i = 0; i < cb.length; i ++) {
            boolean t = false;
            int j;
            for (j = 0; j < ca.length; j ++) {
                if (cb[i] == ca[j]) {
                    t = true;
                }
            }
            if (!t && j >= ca.length) {
                return false;
            }
        }
        return true;
    }

    /**
     * 如果可以使用Java中的数据结构，HashMap和Set可以很方便地解决问题；如果不能，我们可以构造一个“签名”，将每一个字
     *  符映射为整数(范围：0到26)，然后遍历A中的每一个字符，将32位整数的对应位置1(整数初始为0)，
     *  最后遍历B中的每一个字符，判断每一个字符代表的整数在整数中是否已置位。时间复杂度O(n)，空间复杂度O(1)
     *
     * 例： a -> ABC    b -> AB
     *
     * hash                 000000
     * ca[0]    (1 << 0)    000001
     * hash       |         000001
     * ca[1]    (1 << 1)    000011
     * hash       |         000011
     * ca[2]    (1 << 2)    000111
     * hash       |         000111
     *
     */
    public boolean stringContain2(String a, String b) {

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int hash = 0;
        for (char c: ca) {
            hash = hash | 1 << (c - 'A');
        }

        for (char c: cb) {
            if ((hash & (1 << (c - 'A'))) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args) {
         N01_02 n = new N01_02();
         System.out.println(n.stringContain2("ABCD", "ABE"));
    }
}
