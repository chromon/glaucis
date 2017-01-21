package chap2_vector;

import java.util.Arrays;

/**
 * Test MergeSort
 *
 * Created by Ellery on 2016/11/23.
 */

public class MergeSortTest {

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

        // 临时数组
        int k = 0;
        int[] temp = new int[hi - lo];

        // 前后分段起始位置
        int i = lo, j = mi;

        // 把较小的数先移到新数组中。两段中一段越界，就全部终止，另一段剩余部分直接复制到临时数组
        while (i < mi && j < hi) {
            if (_elem[i] <= _elem[j]) {
                temp[k ++] = _elem[i ++];
            } else {
                temp[k ++] = _elem[j ++];
            }
        }

        // 把前一分段剩余的数移入数组
        while (i < mi) {
            temp[k ++] = _elem[i ++];
        }

        // 把一分段剩余的数移入数组
        while (j < hi) {
            temp[k ++] = _elem[j ++];
        }

        // 把新数组中的数覆盖 _elem 数组
        for (k = 0; k < temp.length; k++) {
            _elem[k + lo] = temp[k];
        }
    }

    public static void main(String[] args) {

        int[] _elem = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};
        MergeSortTest.mergeSort(_elem, 0, _elem.length);
        System.out.println(Arrays.toString(_elem));
    }
}
