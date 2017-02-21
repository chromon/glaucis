package code;

import java.util.Random;

/**
 * 寻找最小的 k 个数
 *
 * Created by Ellery on 2017/2/21.
 */

public class N02_01 {

    private void quickSort(int[] a, int lo, int hi) {

        if (hi - lo > 1) {
            int mi = this.partition(a, lo, hi);
            this.quickSort(a, lo, mi);
            this.quickSort(a, mi + 1, hi);
        }

    }

    private int partition(int[] a, int lo, int hi) {

        Random random = new Random();
        int t = random.nextInt(hi - 1) % (hi - lo + 1) + lo;
        swap(a, lo, t);

        int pivot = a[lo];

        while (lo < hi) {

            while ((lo < hi) && (pivot <= a[hi])) {
                hi --;
            }

            a[lo] = a[hi];

            while ((lo < hi) && (pivot >= a[lo])) {
                lo ++;
            }

            a[hi] = a[lo];
        }
        a[lo] = pivot;

        return lo;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 快速排序 取前 k 个数
     * @param a
     * @param k
     */
    private void selectK(int[] a, int k) {
        this.quickSort(a, 0, a.length - 1);
        for (int i = 0; i < k; i ++) {
            System.out.print(a[i]);
        }
    }

    /**
     * 1、遍历n个数，把最先遍历到的k个数存入到大小为k的数组中，假设它们即是最小的k个数；
     * 2、对这k个数，利用选择或交换排序找到这k个元素中的最大值kmax（找最大值需要遍历这k个数，时间复杂度为O（k））；
     * 3、继续遍历剩余n-k个数。假设每一次遍历到的新的元素的值为x，把x与kmax比较：
     *      如果x < kmax ，用x替换kmax，并回到第二步重新找出k个元素的数组中最大元素kmax‘；
     *      如果x >= kmax，则继续遍历不更新数组。
     *
     *  @param a
     * @param k
     */
    private void selectK2(int[] a, int k) {

        int kMaxI = this.getKMax(a, k);
        int kMax = a[kMaxI];

        for (int i = k; i < a.length; i ++) {
            if (a[i] < kMax) {
                a[kMaxI] = a[i];
                kMaxI = this.getKMax(a, k);
                kMax = a[kMaxI];
            }
        }

        for (int i = 0; i < k; i ++) {
            System.out.print(a[i]);
        }
    }

    private int getKMax(int[] a, int k) {
        int kMax = a[0];
        int kMaxI = 0;

        for (int i = 0; i < k; i ++) {
            if (a[i] > kMax) {
                kMax = a[i];
                kMaxI = i;
            }
        }

        return kMaxI;
    }

    public static void main(String[] args) {
        N02_01 n = new N02_01();
        int[] a = {6, 3, 8, 2, 0, 5, 9, 4, 1, 7};
        n.selectK2(a, 3);
    }
}
