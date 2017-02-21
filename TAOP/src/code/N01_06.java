package code;

/**
 * 全排列
 *
 * Created by Ellery on 2017/2/21.
 */

public class N01_06 {

    /**
     * 下一个排列算法，即下一个字典序
     * 定义
     *      升序：相邻两个位置ai < ai+1，ai 称作该升序的首位
     * 步骤（二找、一交换、一翻转）
     *      找到排列中最后（最右）一个升序的首位位置i，x = ai
     *      找到排列中第i位右边最后一个比ai 大的位置j，y = aj
     *      交换x，y
     *      把第(i+ 1)位到最后的部分翻转
     *
     * @param c
     * @return
     */
    public boolean next_permutation(char[] c) {

        // 找到排列中最后（最右）一个升序的首位位置 i
        int i;
        for (i = c.length - 2; (i >= 0) && (Character.getNumericValue(c[i]) >= Character.getNumericValue(c[i + 1])); i --);

        if (i < 0) {
            System.out.println("已经找到所有排列");
            return false;
        }

        // 找到排列中第 i 位右边最后一个比 ai 大的位置 j
        int j;
        for (j = c.length - 1; (j > i) && (Character.getNumericValue(c[j]) <= Character.getNumericValue(c[i])); j --);

        // 交换 c[i] 和 c[j]
        char t = c[i];
        c[i] = c[j];
        c[j] = t;

        // 把第 (i + 1) 位到最后 (length - 1) 的部分翻转
        this.reverse(c, i + 1, c.length - 1);

        for (char ch: c) {
            System.out.print(ch);
        }
        System.out.println();

        return true;
    }

    private void reverse(char[] c, int m, int n) {
        for (int i = m, j = n; i < j; i ++, j --) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
    }

    public static void main(String[] args) {
        N01_06 n = new N01_06();
        char[] c = "12345".toCharArray();
//        System.out.println(n.next_permutation(c));

        while (n.next_permutation(c));
    }
}
