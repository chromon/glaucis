package chap3;

/**
 * 自定义 List
 *
 * Created by Ellery on 2016/11/29.
 */

/**
 * 自定义 List Node
 * @param <T> 数据类型
 */
class ListNode<T extends Comparable<T>> {

    // 数值
    T data;

    // 前驱节点
    ListNode<T> pred;

    // 后继节点
    ListNode<T> succ;

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

/**
 * 自定义 List
 *      不可见节点：header，trailer    对应秩：-1，n
 *      可见节点：first，last         对应秩：0，n - 1
 *
 * @param <T> 数据类型
 */
public class MyList<T extends Comparable<T>> {

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
     * 得到首节点
     * @return 返回首节点
     */
    private ListNode<T> first() {
        return this.header.succ;
    }

    /**
     * 得到末节点
     * @return 返回末节点
     */
    private ListNode<T> last() {
        return this.trailer.pred;
    }

    /**
     * 无序查找算法
     *      节点 P 可能是 trailer 的 n 个真前驱中，查找到数值等于 e 的最后者
     * @param e 被查找数值
     * @param n 查找范围
     * @param p 查找起始位置
     * @return 查找到的节点，不存在时返回 null
     */
    private ListNode<T> find(T e, int n, ListNode<T> p) {

        while (0 < n --) {
            p = p.pred;
            if (e == p.data) {
                return p;
            }
        }
        return null;
    }

    /**
     * 在节点 p 之前插入 e
     * @param p 插入位置参照节点
     * @param e 插入内容
     * @return 插入的节点
     */
    private ListNode<T> insertBefore(ListNode<T> p, T e) {
        this._size ++;
        return p.insertAsPred(e);
    }

    /**
     * 在节点 p 之后插入 e
     * @param p 插入位置参照节点
     * @param e 插入内容
     * @return 插入的节点
     */
    private ListNode<T> insertAfter(ListNode<T> p, T e) {
        this._size ++;
        return p.insertAsSucc(e);
    }

    /**
     * 插入新的末节点，即在尾节点之前插入新节点
     * @param e 被插入内容
     */
    private void insertAsLast(T e) {

        this.insertBefore(this.trailer, e);
    }

    /**
     * 插入新的首节点，即在头结点之后插入新节点
     * @param e 被插入的内容
     */
    private void insertAsFirst(T e) {

        this.insertAfter(this.header, e);
    }

    /**
     * 从节点 p 开始复制 n 个节点到新的列表
     * @param p 被复制起始节点
     * @param n 复制数量
     */
    private void copyNodes(ListNode<T> p, int n) {

        // 创建头尾哨兵节点，并初始化
        this.init();

        // 自 p 起的 n 个节点作为末节点逐项插入
        while (0 < n --) {
            this.insertAsLast(p.data);
            p = p.succ;
        }
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
     * 无序列表唯一化
     *      去除重复数据
     * @return 返回被删除的元素总数
     */
    private int deduplicate() {

        if (this._size < 2) {
            return 0;
        }

        int oldSize = this._size;
        ListNode<T> p = new ListNode<T>();
        int r = 1;

        while (this.trailer != (p = p.succ)) {
            // 在 p 的 r 个真前驱中查找相同
            ListNode<T> q = this.find(p.data, r, p);
            if (q != null) {
                this.remove(q);
            } else {
                r ++;
            }
        }

        return oldSize - this._size;
    }

    /**
     * 有序列表唯一化
     * @return 返回被删除的元素总数
     */
    private int uniquify() {

        if (this._size < 2) {
            return 0;
        }

        int oldSize = this._size;

        ListNode<T> p = this.first(), q;

        while (this.trailer != (q = p.succ)) {
            if (p.data != q.data) {
                p = q;
            } else {
                this.remove(q);
            }
        }

        return oldSize - this._size;
    }

    /**
     * 有序列表查找
     *      节点 p 的 n 个真前驱中，查找不大于 e 的最后者
     * @param e 查找数值
     * @param n 查找个数
     * @param p 查找起始点
     * @return 要查找的节点，如果没找到，则返回数据不大于 e 的最后者
     */
    private ListNode<T> search(T e, int n, ListNode<T> p) {

        while (0 <= n --) {
            p = p.pred;
            if(p.data.compareTo(e) <= 0) {
                break;
            }
        }
        return p;
    }

    /**
     * 选出从起始位置 p 的 n 节点的最大值
     * @param p 起始节点
     * @param n 查找范围
     * @return 最大值节点
     */
    private ListNode<T> selectMax(ListNode<T> p, int n) {
        ListNode<T> max = p;

        for (ListNode<T> cur = p; 1 < n; n --) {
            cur = cur.succ;
            if (cur.data.compareTo(max.data) >= 0) {
                max = cur;
            }
        }

        return max;
    }

    /**
     * 选择排序 O(n^2)
     *      对起点位置 p 的连续的 n 个节点进行排序
     * @param p 排序的起始节点
     * @param n 待排序的接待数目
     */
    private void selectionSort(ListNode<T> p, int n) {

        // 待排序的节点区间
        ListNode<T> head = p.pred;
        ListNode<T> tail = p;

        // tail 节点为 p + n 是一个虚拟的哨兵节点（开区间）
        for (int i = 0; i < n; i ++) {
            tail = tail.succ;
        }

        while (1 < n) {
            // 找出待排序区间最大值，移动到 tail 节点的前面
            this.insertBefore(tail, this.remove(this.selectMax(head.succ, n)));
            tail = tail.pred;
            n --;
        }
    }

    /**
     * 插入排序 O(n^2)
     *      起始于位置 p 的 n 个节点做插入排序
     * @param p 起始节点
     * @param n 待排序节点数目
     */
    private void insertionSort(ListNode<T> p, int n) {

        // r 为已排序的节点数目
        for (int r = 0; r < n; r ++) {
            // 查找 p 前面的 r 个前驱中不大于 p.data 的节点，将 p.data 插入到该节点前面
            this.insertBefore(this.search(p.data, r, p), p.data);
            // p 节点向后移，并删除前一个节点（insertBefore 会创建一个新节点）
            p = p.succ;
            this.remove(p.pred);
        }
    }
}
