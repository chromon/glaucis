package code;

/**
 * 最大连续子数组和
 * 输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值，要求时间复杂度为O(n)。
 *
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2， 因此输出为该子数组的和18。
 *
 * Created by Ellery on 2017/2/25.
 */

public class N02_04 {

    /**
     * 子数组 a[i....j] 最大值
     *
     * @param a
     * @return
     */
    private int maxSubSum(int[] a) {

        int max = a[0];
        int currMax = 0;

        for (int i = 0; i < a.length; i ++) {
            for (int j = i; j < a.length; j ++) {
                for (int k = i; k < j; k ++) {
                    currMax += a[k];
                    if (currMax > max) {
                        max = currMax;
                    }
                }
                currMax = 0;
            }
        }

        return max;
    }

    private int maxSubSum2(int[] a) {

        int max = a[0];
        int currMax = 0;

        for (int i = 0; i < a.length; i ++) {
            currMax = (currMax + a[i] < a[i])? a[i]: a[i] + currMax;
            max = (currMax > max)? currMax: max;
        }

        return max;
    }

    public static void main(String[] args) {
        N02_04 n = new N02_04();
        int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(n.maxSubSum2(a));
    }
}
