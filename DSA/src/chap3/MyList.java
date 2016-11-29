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
    private ListNode() {

    }

    /**
     * 默认构造
     * @param e 数值
     * @param p 前驱
     * @param s 后继
     */
    private ListNode(T e, ListNode<T> p, ListNode<T> s) {

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
}
