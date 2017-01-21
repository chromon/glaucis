package chap2_vector;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by Ellery on 2016/11/28.
 */
public class BubbleSortTest {

    private int[] _elem = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};

    /**
     * 改进版冒泡排序，最好 O(n)，最坏 O(n^2)
     *      记录最后一个逆序对的位置 a，所以只用判断 [lo, a] 的内容，而 a 后面不用考虑
     * @param lo 排序起始区间
     * @param hi 排序结束区间
     */
    private void bubbleSort(int lo, int hi) {

        // 逐趟扫描交换
        while (lo < hi) {
            hi = bubble(lo, hi);
        }
    }

    /**
     * 一趟冒泡排序
     * @param lo 排序起始区间
     * @param hi 排序结束区间
     * @return 最右侧逆序对的位置
     */
    private int bubble(int lo, int hi) {

        // 最右侧逆序对位置初始化为 [lo - 1, lo]
        int last = lo;

        while (++ lo < hi) {
            // 逆序则交换
            if (this._elem[lo - 1] > this._elem[lo]) {

                // 更新最右侧逆序对的位置为新的 lo
                last = lo;

                int temp = this._elem[lo -1];
                this._elem[lo - 1] = this._elem[lo];
                this._elem[lo] = temp;
            }
        }
        // 返回最右侧逆序对的位置
        return last;
    }

    private void display() {
        System.out.println(Arrays.toString(_elem));
    }

    public static void main(String[] args) {
        BubbleSortTest bst = new BubbleSortTest();
        bst.bubbleSort(0, 10);
        bst.display();
    }
}
