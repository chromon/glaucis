package code;

/**
 * 一个台阶总共有 n 级，如果一次可以跳 1 级，也可以跳 2 级。
 * 求总共有多少总跳法，并分析算法的时间复杂度。
 *
 * Created by Ellery on 2017/2/25.
 */

public class N02_05 {

    /**
     * 一次上 1 或 2 个
     * @param n
     * @return
     */
    private int step(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        return step(n - 1) + step(n - 2);
    }

    /**
     * 一个人上台阶可以一次上 1 个，2 个，或者 3 个
     * @param n
     * @return
     */
    private int step2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        return step(n - 1) + step(n - 2) + step(n - 3);
    }

    public static void main(String[] args) {
        N02_05 n = new N02_05();
        System.out.println(n.step(5));
    }
}
