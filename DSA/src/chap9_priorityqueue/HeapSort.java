package chap9_priorityqueue;

/**
 * 堆排序
 * Created by Ellery on 2017/2/13.
 */

public class HeapSort<T extends Comparable<T>> {

    private T[] a;

    public HeapSort(T[] a) {
        this.a = a;
    }

    public void heapSort(int lo, int hi) {
        MyCompleteBinaryHeap h = new MyCompleteBinaryHeap(a, hi - lo);
        while (!h.empty()) {
            a[--hi] = (T) h.delMax();
        }

    }

}
