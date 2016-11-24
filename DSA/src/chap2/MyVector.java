package chap2;

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
public class MyVector<T> {

    /* 默认初始容量，物理空间大小 */
    private final int DEFAULT_CAPACITY = 5;

    // 数据大小，逻辑空间大小
    private int _size;

    // 实际容量，物理空间大小
    private int _capacity;

    // 数据存储空间
    private T[] _elem;

    /**
     * 构造方法
     *      使用默认的初始容量创建
     */
    public MyVector() {

        // 通过反射创建数组，使用默认大小
        this._capacity = this.DEFAULT_CAPACITY;
        this._elem = (T[]) Array.newInstance(this._elem.getClass().getComponentType(), this.DEFAULT_CAPACITY);

        // 初始化数据大小
        this._size = 0;
    }

    /**
     * 构造方法
     * @param _capacity 自定义容量大小
     */
    public MyVector(int _capacity) {

        // 通过反射创建数组，手动初始化大小
        this._capacity = _capacity;
        this._elem = (T[]) Array.newInstance(this._elem.getClass().getComponentType(), _capacity);

        // 初始化数据大小
        this._size = 0;

    }

    /**
     * 构造方法
     * @param a 以数组元素初始化 Vector 空间，从数组区间复制
     * @param lo 复制区间起始点，闭区间
     * @param hi 复制区间结束点，开区间
     */
    public MyVector(T[] a, int lo, int hi) {

        // 分配空间
        this(2 * (hi - lo));
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
    public MyVector(MyVector<T> v, int lo, int hi) {

        // 分配空间
        this(2 * (hi - lo));
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
    public MyVector(MyVector<T> v) {

        // 分配空间
        this(2 * v._size);
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
            _elem = (T[]) Array.newInstance(this._elem.getClass().getComponentType(), _capacity <<= 1);

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

        return _elem[i];
    }


    private int insert(int r, T e) {

        // 如有需要进行扩容
        this.expand();

        for (int i = _size; i > r; i --) {
            _elem[i] = _elem[i - 1];
        }

        // 添加新元素，容量增加
        _elem[r] = e;
        _size ++;

        return r;
    }

}
