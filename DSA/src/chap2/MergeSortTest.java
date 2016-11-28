package chap2;

import java.util.Arrays;

/**
 * Test MergeSort
 *
 * Created by Ellery on 2016/11/23.
 */

public class MergeSortTest {

    // private int[] _elem;

//    /**
//     * 归并排序 O(nlogn)
//     * @param lo 起始区间，闭区间
//     * @param hi 结束区间，开区间
//     */
//    private static int[] mergeSort(int[] _elem, int lo, int hi) {
//
//        int mi = (lo + hi) >> 1;
//        if (2 <= hi - lo) {
//            // 前后两段分开排序
//            mergeSort(_elem, lo, mi);
//            mergeSort(_elem, mi, hi);
//
//            // 二路归并
//            merge(_elem, lo, mi, hi);
//        }
//
//        return _elem;
//    }
//
//    /**
//     * 归并排序 合并
//     * @param lo 起始区间，闭区间
//     * @param mi 区间分隔
//     * @param hi 结束区间，开区间
//     */
//    private static void merge(int[] _elem, int lo, int mi, int hi) {
//
//        int[] t = new int[hi - lo];
//
//        int i = lo, j = mi, k = 0;
//
//        // i, j 至少有一个不越界
//        while ((i < mi - lo) && (j < hi - lo)) {
//            // i 不越界；同时，j 越界或 b[j] <= c[k]
//            // 即向量 b 还有剩余的同时，如果向量 c 为空，将 b 余下内容复制到 a
//            // 如果向量 c 不为空，那么如果 b[j] <= c[k]，将 b 首位复制到 a
//            if ((i < mi - lo) && (hi - mi <= j || (_elem[i] <= _elem[j]))) {
//                t[k ++] = _elem[i ++];
//            }
//
//            // j 不越界；同时，i 越界或 c[j] < b[i]
//            if((j < hi - mi) && (mi - lo <= i || (_elem[j] < _elem[i]))) {
//                t[k ++] = _elem[j ++];
//            }
//        }
//
//        // 把新数组中的数覆盖nums数组
//        for (int m = 0; m < t.length; m++) {
//            _elem[m + lo] = t[m];
//        }
//
//    }

//    private void merge2(int lo, int mi, int hi) {
//
//        int[] a = this._elem;
//        // 复制向量，将 _elem lo后的内容复制到向量a，即a[0, hi - lo) = _elem[lo, hi)
//        System.arraycopy(a, lo, a, 0, (hi - lo));
//
//        int lb = mi - lo;
//        // 复制前子向量，b[0, mi - lo) = _elem[lo, mi)
//        int[] b = new int[lb];
//
//        for (int i = 0; i < lb; i ++) {
//            b[i] = a[i];
//        }
//
//        int lc = hi - mi;
//        // 复制后子向量，c[0, hi - mi) = _elem[mi, hi)
//        int[] c = new int[lc];
//        System.arraycopy(a, mi, c, 0, (hi - mi));
//
//        int i = 0, j = 0, k = 0;
//        // j 和 k 至少有一个不越界，否则退出
//        while ((j < lb) || (k < lc)) {
//            // j 不越界；同时，c 越界或 b[j] <= c[k]
//            // 即向量 b 还有剩余的同时，如果向量 c 为空，将 b 余下内容复制到 a
//            // 如果向量 c 不为空，那么如果 b[j] <= c[k]，将 b 首位复制到 a
//            if ((j < lb) && (lc <= k || (b[j] <= c[k]))) {
//                a[i ++] = b[j ++];
//            }
//
//            // k 不越界；同时，b 越界或 c[k] < b[j]
//            if((k < lc) && (lb <= j || (c[k] < b[j]))) {
//                a[i ++] = c[k ++];
//            }
//        }
//    }

    /**
     * 归并排序 O(nlogn)
     * @param lo 起始区间，闭区间
     * @param hi 结束区间，开区间
     */
    public static int[] mergeSort(int[] _elem, int lo, int hi) {

        int mi = (lo + hi) >> 1;
        if (2 <= hi - lo) {
            // 前后两段分开排序
            mergeSort(_elem, lo, mi);
            mergeSort(_elem, mi , hi);

            // 前后二路归并
            merge(_elem, lo, mi, hi);
        }
        return _elem;
    }

    /**
     * 归并排序 二路归并
     * @param lo 起始区间，闭区间
     * @param mi 区间分隔
     * @param hi 结束区间，开区间
     */
    public static void merge(int[] _elem, int lo, int mi, int hi) {

        int[] temp = new int[hi - lo];

        // 前后分段起始位置
        int i = lo, j = mi;
        int k = 0;

        // 把较小的数先移到新数组中
        while (i < mi && j < hi) {
            if (_elem[i] <= _elem[j]) {
                temp[k ++] = _elem[i ++];
            } else {
                temp[k ++] = _elem[j ++];
            }
        }

        // 把左边剩余的数移入数组
        while (i < mi) {
            temp[k ++] = _elem[i ++];
        }

        // 把右边边剩余的数移入数组
        while (j < hi) {
            temp[k ++] = _elem[j ++];
        }

        // 把新数组中的数覆盖nums数组
        for (k = 0; k < temp.length; k++) {
            _elem[k + lo] = temp[k];
        }
    }

    public static void main(String[] args) {

        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
//        int[] nums = {9, 7};

        MergeSortTest.mergeSort(nums, 0, nums.length );
        System.out.println(Arrays.toString(nums));
    }
}
