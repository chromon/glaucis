package chap9_priorityqueue;

import chap2_vector.MyVector;

/**
 * 完全二叉堆
 *      完全二叉树（逻辑上） ==> 向量（物理上） ==> 堆
 *      逻辑节点与物理元素依层序遍历相对应
 *      如：
 *          1: 秩为 i 元素的父节点如果存在，则父节点秩应为 （i - 1）/ 2
 *          2: 秩为 i 的元素如果有左孩子，则左孩子的秩为  2 * i + 1
 *          3: 秩为 i 的元素如果有右孩子，则右孩子的秩为 （i + 1) * 2
 *
 *      堆序性：
 *          父节点值一定大于等于子节点
 *
 * Created by Ellery on 2017/1/24.
 */

public class MyCompleteBinaryHeap<T extends Comparable<T>> extends MyVector {

    /**
     * 批量建堆
     *      给定数组建立一个完全二叉堆
     */
    public MyCompleteBinaryHeap(T[] a, int n) {
        copyFrom(a, 0, n);
        heapify(n);
    }

    /**
     * 自下而上的下虑
     * @param n
     */
    private void heapify(int n) {
        // 叶子节点下虑是没有意义的，所以从最后一个内部节点开始下虑
        for (int i = lastInternal(n); i >= 0; i --) {
            percolateDown(n, i);
        }
    }

    /**
     * 取最后一个内部节点的秩
     *      n/2 去下整 - 1
     * @param n 规模
     * @return 内部节点秩
     */
    private int lastInternal(int n) {
        return (int) Math.floor(n / 2) - 1;
    }

    /**
     * 最大值
     * @return 向量首元素 == 完全二叉树树根（堆序性）
     */
    public T getMax() {
        return (T)_elem[0];
    }

    /**
     * 插入算法
     *  再向量中作为末元素插入，所以该元素的秩为 _size - 1
     * @param e 插入的内容
     */
    public void inserth(T e) {
        insert(_size - 1, e);
        // 上虑
        percolateUp(_size - 1);
    }

    /**
     * 上虑
     *      新插入节点逻辑上相当于完全二叉树的新叶子节点，由于要堆序性，
     *      所以该叶子节点需要逐层和自己的父节点相比较，如果大于父节点，则与父节点交换位置
     *      直至小于父节点
     * @param i 新出入叶子节点的秩
     * @return 上虑调整之后新插入节点的秩
     */
    public int percolateUp(int i) {
        // 父节点存在
        while (parentValid(i)) {
            // 取得父节点的秩
            int j = parent(i);
            // 当前元素小于父节点，直接跳出结束循环
            if (_elem[i].compareTo(_elem[j]) < 0) {
                break;
            }

            // 交换父子节点
            T t = (T)_elem[i];
            _elem[i] = _elem[j];
            _elem[j] = t;

            // 将新插入节点的秩设为其原父节点的秩
            i = j;
        }
        return i;
    }

    /**
     * 父节点是否存在
     * @param i 子节点的秩
     * @return 是否存在
     */
    private boolean parentValid(int i) {
        return (i - 1) / 2 >= 0? true: false;
    }

    /**
     * 父节点的秩
     * @param i 子节点的秩
     * @return 秩
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 删除最大元素
     * @return 最大元素
     */
    public T delMax() {
        // 备份最大值
        T max = (T)_elem[0];
        // 将最后一个叶子节点上移到树根节点
        _elem[0] = _elem[--_size];
        // 下虑
        percolateDown(_size, 0);
        // 返回最大元素
        return max;
    }

    /**
     * 下虑
     * @param n 总共规模为 n 的完全二叉树
     * @param i 对秩为 i 的元素实施下虑
     * @return 最终节点秩
     */
    private int percolateDown(int n, int i) {

        // 节点 i 与两个孩子中的最大者
        int j ;
        // 只要 i 不是 j ，就表明至少有一个孩子比 i 大，此时交换 i 与该孩子
        while (i != (j = properParent((T[])_elem, n, i))) {
            T t = (T)_elem[i];
            _elem[i] = _elem[j];
            _elem[j] = t;

            i = j;
        }
        return i;
    }

    /**
     * 节点 i 与两个孩子中的最大者
     * @param _elem 逻辑向量
     * @param n 总规模
     * @param i 秩
     * @return 最大者的秩
     */
    private int properParent( T[] _elem, int n, int i) {

        int lRank = 2 * i + 1;
        int rRank = (i + 1) * 2;

        T l = lRank <= n? _elem[lRank]: null;
        T r = rRank <= n? _elem[rRank]: null;

        T max = _elem[i];
        int maxRank = i;

        if (l != null && l.compareTo(max) > 0) {
            maxRank = lRank;
        }

        if (r != null && r.compareTo(max) > 0) {
            maxRank = rRank;
        }

        return maxRank;
    }
}
