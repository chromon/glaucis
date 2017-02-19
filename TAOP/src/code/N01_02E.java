package code;

/**
 * 变位词
 * 如果两个字符串的字符一样，但是顺序不一样，被认为是兄弟字符串，比如bad和adb即为兄弟字符串.
 * 现提供一个字符串，如何在字典中迅速找到它的兄弟字符串，请描述数据结构和查询过程。
 *
 * Created by Ellery on 2017/2/19.
 */

public class N01_02E {

    public boolean broString(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int hash = 0;
        for (char c: ca) {
            hash = hash | 1 << (c - 'a');
        }

        for (char c: cb) {
            if ((hash & (1 << (c - 'a'))) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N01_02E n = new N01_02E();
        System.out.println(n.broString("bad", "adb"));
    }
}
