package chap11_sort;

import java.util.Random;

/**
 * 快速排序
 * Created by Ellery on 2017/2/15.
 */

public class QuickSort {

    private int[] _a;

    public QuickSort(int[] a) {
        this._a = a;
    }

    /**
     * 快速排序 [lo, hi)
     *  O(nlogn)
     * @param lo 起始位置
     * @param hi 结束位置
     */
    public void quickSort(int lo, int hi) {
        if (hi - lo >= 2) {
            int mi = partition(lo, hi - 1);
            quickSort(lo, mi);
            quickSort(mi + 1, hi);
        }
    }

    /**
     * 轴点构造算法，构造 [lo, hi) 区间内的轴点的位置
     * @param lo
     * @param hi
     * @return
     */
    private int partition(int lo, int hi) {
        //任选一个元素与首元素交换

        Random random = new Random();
        int t = random.nextInt(hi - 1) % (hi - lo + 1) + lo;
        swap(lo, t);

        int pivot = this._a[lo];

        // 从两端交替向中间扫描
        while(lo < hi) {

            // 不小于轴点
            while((lo < hi) && (pivot <= this._a[hi])) {
                // 向左扩展右端的子向量
                hi --;
            }
            // 小于轴点的放入左边子向量空闲位置
            this._a[lo] = this._a[hi];

            // 不大于轴点
            while(( lo < hi) && ( this._a[lo] <= pivot)) {
                lo ++;
            }
            // 大于轴点的放入右边子向量空闲位置
            this._a[hi] = this._a[lo];
        }

        // 将备份的轴点放入左右子向量中间
        this._a[lo] = pivot;

        // 返回轴点的秩
        return lo;
    }

    private void swap(int i, int j) {
        int t = this._a[i];
        this._a[i] = this._a[j];
        this._a[j] = t;
    }

    private void print() {
        for (int i = 0; i < this._a.length; i ++) {
            System.out.print(this._a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 3, 8, 2, 0, 5, 9, 4, 1, 7};
        QuickSort q = new QuickSort(a);
        q.quickSort(0, 10);
        q.print();
    }
}
