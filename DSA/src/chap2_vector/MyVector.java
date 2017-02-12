package chap2_vector;

import java.lang.reflect.Array;

/**
 * 自定义 Vector 类
 *
 * @param <T>
 *     以泛型定义 Vector 类型
 *
 * Created by Ellery on 2016/11/23.
 */

@SuppressWarnings("unchecked")
public class MyVector<T extends Comparable<T>> {

    /* 默认初始容量，物理空间大小 */
    private final int DEFAULT_CAPACITY = 5;

    // 数据大小，逻辑空间大小
    public int _size;

    // 实际容量，物理空间大小
    private int _capacity;

    // 数据存储空间
    public T[] _elem;

    // 存储元素类型
    private Class<T> clazz;

    /**
     * 构造方法
     *      使用默认的初始容量创建
     */
    public MyVector(Class<T> clazz) {

        // 通过反射创建数组，使用默认大小
        this._capacity = this.DEFAULT_CAPACITY;
        this.clazz = clazz;
        this._elem = (T[]) Array.newInstance(this.clazz, this.DEFAULT_CAPACITY);

        // 初始化数据大小
        this._size = 0;
    }

    public MyVector() {}

    /**
     * 构造方法
     * @param _capacity 自定义容量大小
     */
    public MyVector(int _capacity, Class<T> clazz) {

        // 通过反射创建数组，手动初始化大小
        this._capacity = _capacity;
        this.clazz = clazz;
        this._elem = (T[]) Array.newInstance(clazz, _capacity);

        // 初始化数据大小
        this._size = 0;

    }

    /**
     * 构造方法
     * @param a 以数组元素初始化 Vector 空间，从数组区间复制
     * @param lo 复制区间起始点，闭区间
     * @param hi 复制区间结束点，开区间
     */
    public MyVector(T[] a, int lo, int hi, Class<T> clazz) {

        // 分配空间
        this(2 * (hi - lo), clazz);
        this.clazz = clazz;
        this._capacity = 2 * (hi - lo);
        // 规模清零
        this._size = 0;

        this.copyFrom(a, lo, hi);
    }

    /**
     * 构造方法
     *      从已存在向量（Vector）进行区间复制
     * @param v 被复制的向量
     * @param lo 复制区间起始点，闭区间
     * @param hi 复制区间结束点，开区间
     */
    public MyVector(MyVector<T> v, int lo, int hi, Class<T> clazz) {

        // 分配空间
        this(2 * (hi - lo), clazz);
        this.clazz = clazz;
        this._capacity = 2 * (hi - lo);
        // 规模清零
        this._size = 0;

        this.copyFrom(v._elem, lo, hi);
    }

    /**
     * 构造方法
     *      从整个向量复制
     * @param v 被复制的向量
     */
    public MyVector(MyVector<T> v, Class<T> clazz) {

        // 分配空间
        this(2 * v._size, clazz);
        this.clazz = clazz;
        this._capacity = 2 * v._size;
        // 规模清零
        this._size = 0;

        this.copyFrom(v._elem, 0, v._size);
    }

    /**
     * 复制方法
     *      从已有数组区间内复制元素到向量
     * @param a 被复制数组
     * @param lo 复制区间起始点，闭区间
     * @param hi 复制区间结束点，开区间
     */
    private void copyFrom(T[] a, int lo, int hi) {

        while (lo < hi) {
            this._elem[this._size ++] = a[lo ++];
        }
    }

    /**
     * 向量空间不足时，动态扩容
     */
    private void expand() {

        if (_size >= _capacity) {

            T[] oldElem = _elem;
            _elem = (T[]) Array.newInstance(this.clazz, _capacity <<= 1);

            for (int i = 0; i < _size; i ++) {
                _elem[i] = oldElem[i];
            }
        }
    }

    /**
     * 获取向量元素
     *
     * @param i 向量元素下标
     * @return 向量元素
     */
    private T get(int i) {

        return this._elem[i];
    }

    /**
     * 向量中插入元素
     *
     * @param r 插入位置
     * @param e 插入内容
     * @return 返回插入位置
     */
    public int insert(int r, T e) {

        // 如有需要进行扩容
        this.expand();

        for (int i = this._size; i > r; i --) {
            this._elem[i] = this._elem[i - 1];
        }

        // 添加新元素，容量增加
        this._elem[r] = e;
        this._size ++;

        return r;
    }

    /**
     * 区间删除
     *      删除 [lo, hi) 之间的内容
     *
     * @param lo 删除区间起始位置，闭区间
     * @param hi 删除区间结束位置，开区间
     * @return 被删除的元素数目
     */
    private int remove(int lo, int hi) {

        if (lo == hi) {
            return 0;
        }

        while (hi < this._size) {
            this._elem[lo ++] = this._elem[hi ++];
        }

        this._size = lo;
        // 有必要时缩容
        // this.shrink();

        return hi - lo;
    }

    /**
     * 删除秩为 r 的元素
     * @param r 被删除元素的秩
     * @return 被删除元素
     */
    private T remove(int r) {

        // 备份被删除元素
        T e = this._elem[r];
        this.remove(r, r + 1);
        return e;
    }

    /**
     * 无序向量查找向量中元素为 e 的秩
     * @param e 被查找元素
     * @param lo 查找区间起始
     * @param hi 查找区间结束
     * @return 命中多个元素时返回秩最大的，如果没有找到返回 lo - 1，具体是否命中由上层调用者判断
     */
    private int find(T e, int lo, int hi) {

        while (lo < hi) {
            if (this._elem[hi] == e) {
                break;
            }
            hi --;
        }
        return hi;
    }

    /**
     * 向量遍历
     */
    private void traverse() {

        for (int i = 0; i < this._size; i ++) {
            System.out.println(this._elem[i]);
        }
    }

    /**
     * 逆序对总数
     * @return 返回相邻元素逆序对的总数
     */
    private int disordered() {

        // 逆序对计数器
        int n = 0;

        for (int i = 1; i < this._size; i ++) {
            if (this._elem[i - 1].compareTo(this._elem[i]) > 0) {
                // 如果仅需判断是否有序，首次遇到逆序时即可终止
                n ++;
            }
        }

        // 当且仅当 n = 0 时，向量有序
        return n;
    }

    /**
     * 有序向量唯一化（较低效 O(n^2)）
     *      前后比较是否相同，相同则删掉，后续前移
     * @return 向量规模变化量，即删除的元素总数
     */
    private int uniquify() {

        // 原大小，_size大小由 remove 方法控制
        int oldSize = this._size;

        int i = 0;
        while (i < this._size - 1) {
            // 相同删除后一个，否则转至后一个
            if (this._elem[i] == this._elem[i + 1]) {
                this.remove(i + 1);
            } else{
                i ++;
            }
        }

        // 向量规模变化量，即删除的元素总数
        return oldSize - this._size;
    }

    /**
     * 有序向量去重（高效版 O(n)）
     *      前后比较直到出现不同，将其直接前移
     * @return 被删除元素总数
     */
    private int uniquify2() {

        int i = 0, j = 0;

        while (++ j < this._size) {
            if (this._elem[i] != this._elem[j]) {
                this._elem[++ i] = this._elem[j];
            }
        }

        // 去除尾部多余元素
        this._size = ++ i;
        // this.shrink();

        return j - i;
    }

    /**
     * 有序向量查找接口
     *      约定：有序向量区间v[lo, hi)中，确定不大于 e 的最后一个元素的秩
     *          若 - < e < v[lo], 则返回 lo - 1
     *          若 v[hi] < e < +, 则返回 hi - 1
     *
     * @param e 被查找元素
     * @param lo 查找起始区间
     * @param hi 查找结束区间
     * @return 查找元素的秩
     */
    private int search(T e, int lo, int hi) {

        // 二分查找
        return binSearch(this._elem, e, lo ,hi);

        // 斐波那契查找
        // return fibSearch(this._elem, e, lo, hi);
    }

    /**
     * 二分查找
     *
     * @param a 被查找元素数组
     * @param e 被查找元素
     * @param lo 被查找起始区间
     * @param hi 被查找结束区间
     * @return 命中元素的秩或 -1
     */
    private int binSearch(T[] a, T e, int lo, int hi) {

        // 有效查找区间长度缩短为 1 时结束
        while (1 < hi - lo) {
            int mi = (hi + lo) >> 1;
            if (e.compareTo(a[mi]) < 0) {
                // [lo, mi)
                hi = mi;
            } else {
                // [mi, hi]
                lo = mi;
            }
        }

        // 返回命中元素的秩或 -1
        return (e == a[lo]) ? lo: -1;
    }

    /**
     * 二分查找（改进版）
     *      符合规范：返回不大于 e 的最后一个元素的秩
     * @param a 被查找元素数组
     * @param e 被查找元素
     * @param lo 被查找起始区间
     * @param hi 被查找结束区间
     * @return 命中元素的秩或 -1
     */
    private int binSearch2(T[] a, T e, int lo, int hi) {

        // 有效查找区间长度缩短为 1 时结束
        while (lo < hi) {
            int mi = (hi + lo) >> 1;
            if (e.compareTo(a[mi]) < 0) {
                // [lo, mi)
                hi = mi;
            } else {
                // (mi, hi]
                lo = mi + 1;
            }
        }

        // 返回命中元素的秩或 -1
        return -- lo;
    }

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
            if (this._elem[lo - 1].compareTo(this._elem[lo]) > 0) {

                // 更新最右侧逆序对的位置为新的 lo
                last = lo;

                T temp = this._elem[lo -1];
                this._elem[lo - 1] = this._elem[lo];
                this._elem[lo] = temp;
            }
        }
        // 返回最右侧逆序对的位置
        return last;
    }

    /**
     * 归并排序 O(nlogn)
     * @param lo 起始区间，闭区间
     * @param hi 结束区间，开区间
     */
    private void mergeSort(int lo, int hi) {
        if (hi - lo >= 2) {
            int mi = (lo + hi) >> 1;

            // 前后两段分开排序
            this.mergeSort(lo, mi);
            this.mergeSort(mi, hi);

            // 二路归并
            this.merge(lo, mi, hi);
        }
    }

    /**
     * 归并排序 合并
     * @param lo 起始区间，闭区间
     * @param mi 区间分隔
     * @param hi 结束区间，开区间
     */
    private void merge(int lo, int mi, int hi) {

        T[] a = this._elem;
        // 复制向量，将 _elem lo后的内容复制到向量a，即a[0, hi - lo) = _elem[lo, hi)
        System.arraycopy(a, lo, a, 0, (hi - lo));

        int lb = mi - lo;
        // 复制前子向量，b[0, mi - lo) = _elem[lo, mi)
        T[] b = (T[]) Array.newInstance(this.clazz, lb);

        for (int i = 0; i < lb; i ++) {
            b[i] = a[i];
        }

        int lc = hi - mi;
        // 复制后子向量，c[0, hi - mi) = _elem[mi, hi)
        T[] c = (T[]) Array.newInstance(this.clazz, lc);
        System.arraycopy(a, mi, c, 0, (hi - mi));

        int i = 0, j = 0, k = 0;
        // j 和 k 至少有一个不越界，否则退出
        while ((j < lb) || (k < lc)) {
            // j 不越界；同时，c 越界或 b[j] <= c[k]
            // 即向量 b 还有剩余的同时，如果向量 c 为空，将 b 余下内容复制到 a
            // 如果向量 c 不为空，那么如果 b[j] <= c[k]，将 b 首位复制到 a
            if ((j < lb) && (lc <= k || (b[j].compareTo(c[k]) <= 0))) {
                a[i ++] = b[j ++];
            }

            // k 不越界；同时，b 越界或 c[k] < b[j]
            if((k < lc) && (lb <= j || (c[k].compareTo(b[j]) < 0))) {
                a[i ++] = c[k ++];
            }
        }
    }

}
