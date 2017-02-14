package chap10_string;

/**
 * 字符串
 *      相等： s[0, n) = t[0, n), 长度相等（n = m），且对应的字符相同( s[i] = t[i])
 *
 *      子串： s.substr(i, k) = s[i, i + k), 0 <= i < n, 0 <= k
 *            从 s[i] 起的连续 k 个字符， [0, i) [i, i + k) [i + k, n)
 *
 *      前缀： s.prefix(k) = s.substr(0, k) = s[0, k), 0 <= k <= n
 *            s 中最靠前的 k 个字符， [0, k) [k, n)
 *
 *      后缀： s.suffix(k) = s.substr(n - k, k) = s[n - k, n), 0 <= k <= n
 *            s 中最靠后的 k 个字符 [0, n - k) [n - k, n)
 *
 *      联系： s.substr(i, k) = s.prekix(i + k).suffix(k)
 *
 *      空串： s[0, n = 0), 也是任何串的子串、前缀、后缀
 *
 * Created by Ellery on 2017/2/13.
 */

public class MyString {

    /**
     * 模式匹配 蛮力匹配算法
     * @param p 模式串
     * @param t 文本串
     * @return 匹配位置
     */
    public int matchv1(char[] p, char[] t) {

        int n = t.length;
        int m = p.length;

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (t[i] == p[j]) {
                i ++;
                j ++;
            } else {
                // t 回退，p 复位
                i = i - j - 1;
                j = 0;
            }
        }

        // j = m, i < n 此时 i - j 为匹配位置
        // i = n, j < m 此时 i - j > n - m, n - m 为模式串能够匹配的最靠右最后一个位置，所以此时不匹配
        return i - j;
    }

    /**
     * 模式匹配 蛮力匹配算法2
     * @param p 模式串
     * @param t 文本串
     * @return 匹配位置
     */
    public int matchv2(char[] p, char[] t) {

        int n = t.length;
        int m = p.length;

        int i = 0, j;

        // t 从第 i 个位置起，与 p 中对应的字符逐个比对
        for (i = 0; i < n - m + 1; i ++) {
            for (j = 0; j < m; j ++) {
                // 若失配，p 整体右移一个字符，重新比对
                if (t[i + j] != p[i]) {
                    break;
                }
            }

            // 找到匹配子串
            if (m <= j) {
                break;
            }
        }

        return i;
    }

    /**
     * 模式匹配 KMP算法
     * @param p 模式串
     * @param t 文本串
     * @return 匹配位置
     */
    public int matchKMP(char[] p, char[] t) {

        int[] next = buildNext(p);

        int n = t.length;
        int m = p.length;

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (j < 0 || t[i] == p[j]) {
                i ++;
                j ++;
            } else {
                j = next[j];
            }
        }

        // j = m, i < n 此时 i - j 为匹配位置
        // i = n, j < m 此时 i - j > n - m, n - m 为模式串能够匹配的最靠右最后一个位置，所以此时不匹配
        return i - j;
    }

    public int[] buildNext(char[] p) {
        int m = p.length, j = 0;
        int[] next = new int[m];
        int t = next[0] = -1;

        while (j < m - 1) {
            if (t < 0 || p[j] == p[t]) {
                next[ ++ j ] = ++ t;
            } else {
                t = next[t];
            }
        }
        return next;
    }

}
