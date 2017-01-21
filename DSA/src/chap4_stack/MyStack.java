package chap4_stack;

import java.lang.reflect.Array;

/**
 * 自定义 Stack
 * Created by Ellery on 2016/12/1.
 */

@SuppressWarnings("unchecked")
public class MyStack<T extends Comparable<T>> {

    /* 默认初始容量，物理空间大小 */
    private final int DEFAULT_CAPACITY = 10;

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
    public MyStack(Class<T> clazz) {

        // 通过反射创建数组，使用默认大小
        this._capacity = this.DEFAULT_CAPACITY;
        this._elem = (T[]) Array.newInstance(clazz, this.DEFAULT_CAPACITY);

        // 初始化数据大小
        this._size = 0;
    }

    /**
     * 构造方法
     * @param _capacity 自定义容量大小
     */
    public MyStack(int _capacity, Class<T> clazz) {

        // 通过反射创建数组，手动初始化大小
        this._capacity = _capacity;
        this._elem = (T[]) Array.newInstance(clazz, _capacity);

        // 初始化数据大小
        this._size = 0;

    }

    /**
     * 获取栈大小
     * @return 返回栈中元素个数
     */
    public int size() {
        return this._size;
    }

    /**
     * 判断栈是否为空
     * @return 栈为空时返回 true
     */
    public boolean empty() {
        return this._size == 0? true: false;
    }

    /**
     * 获取栈顶元素
     * @return 数组中最后一个元素
     */
    public T top() {
        return this._elem[this._size - 1];
    }

    /**
     * 出栈
     * @return 将栈顶元素弹出
     */
    public T pop() {
        T e = this._elem[this._size - 1];
        this._size --;
        return e;
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
     * 入栈
     * @return 向栈中添加元素
     */
    public void push(T e) {
        // 如果有必要扩容
        this.expand();

        this._elem[this._size] = e;
        this._size ++;
    }

    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>(Integer.class);
        s.push(1);
        s.push(2);
        System.out.println(s.empty());
        System.out.println(s.pop());
        s.push(3);
        s.push(4);
        System.out.println(s.size());

        System.out.println("0000");
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());

        for (int i = s.size(); 0 < i; i --) {
            System.out.println(s.pop());
        }

    }
}
