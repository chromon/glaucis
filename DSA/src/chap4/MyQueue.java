package chap4;

/**
 * 自定义队列
 * Created by Ellery on 2016/12/4.
 */

/**
 * 自定义 List Node
 * @param <T> 数据类型
 */
class ListNode<T extends Comparable<T>> {

    // 数值
    public T data;

    // 前驱节点
    public ListNode<T> pred;

    // 后继节点
    public ListNode<T> succ;

    /**
     * 针对 header 和 trailer 的构造
     */
    public ListNode() {}

    /**
     * 默认构造
     * @param e 数值
     * @param p 前驱
     * @param s 后继
     */
    public ListNode(T e, ListNode<T> p, ListNode<T> s) {

        this.data = e;
        this.pred = p;
        this.succ = s;

    }

    /**
     * 前插入
     * @param e 插入数值
     * @return 插入节点
     */
    ListNode<T> insertAsPred(T e) {

        // 创建一个节点 n，n 的前驱为当前节点的前驱，n 的后继为当前节点
        ListNode<T> n = new ListNode<T>(e, this.pred, this);

        // 当前节点的前驱的后继改为 n，当前节点的前驱改为 n
        this.pred.succ = n;
        this.pred = n;

        return n;
    }

    /**
     * 后插入
     * @param e 插入数值
     * @return 插入节点
     */
    ListNode<T> insertAsSucc(T e) {

        // 创建一个节点 n，n 的前驱为当前节点，n 的后继为当前节点的后继
        ListNode<T> n = new ListNode<T>(e, this, this.succ);

        // 当前节点的后继的前驱改为 n，当前节点的后继改为 n
        this.succ.pred = n;
        this.succ = n;

        return n;
    }
}

public class MyQueue<T extends Comparable<T>> {

    // 规模
    private int _size;

    // 不可见的头尾哨兵，
    private ListNode<T> header, trailer;

    private void init() {

        // 创建头尾哨兵节点
        this.header = new ListNode<T>();
        this.trailer = new ListNode<T>();

        // 互联
        this.header.succ = this.trailer;
        this.header.pred = null;

        this.trailer.pred = this.header;
        this.trailer.succ = null;

        // 初始化规模
        this._size = 0;
    }

    /**
     * 队列规模
     * @return 长度
     */
    public int size() {
        return this._size;
    }

    /**
     * 判断队列是否为空
     * @return true 为空
     */
    public boolean empty() {
        return this._size == 0;
    }

    /**
     * 得到首节点
     * @return 返回首节点
     */
    private ListNode<T> first() {
        return this.header.succ;
    }

    /**
     * 尾节点
     * @return 返回尾节点
     */
    private ListNode<T> last() {
        return this.trailer.pred;
    }

    /**
     * 删除节点 p
     * @param p 被删除节点
     * @return 被删除节点内容
     */
    private T remove(ListNode<T> p) {

        // 备份数据，返回
        T e = p.data;

        p.pred.succ = p.succ;
        p.succ.pred = p.pred;

        this._size --;

        return e;
    }

    /**
     * 入队
     * @param e 带插入数值
     */
    public void enqueue(T e) {
        this._size ++;
        // 尾节点前插入 e
        this.trailer.insertAsPred(e);
    }

    /**
     * 出队
     * @return 返回队首元素
     */
    public T dequeue() {
        return this.remove(this.first());
    }

    /**
     * 队首
     * @return 返回队首元素
     */
    public T front() {
        return this.first().data;
    }

    /**
     * 队尾
     * @return 返回队尾元素
     */
    public T rear() {
        return this.last().data;
    }
}
