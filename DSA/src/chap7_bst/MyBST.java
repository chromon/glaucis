package chap7_bst;

import chap5_binarytree.*;

/**
 * Created by Ellery on 2017/1/6.
 * 二叉树搜索树（Binary Search Tree）：寻关键码访问
 *
 * 顺序性： 任一节点均不小于左后代，不大于右后代
 */

/**
 * 词条类
 * @param <K>
 * @param <V>
 */
class Entry<K extends Comparable<K>, V extends Comparable<V>> {

    // 关键码
    K key;

    // 数值
    V value;

}

public class MyBST<T extends Comparable<T>> extends MyBinTree {

    // 命中节点的父节点
    private BinNode<T> _hot;

    /**
     * 二叉搜索树
     * @param e 要查找的数值
     * @return 返回查找到的节点
     */
    public BinNode<T> search(T e) {
        // 从根节点查找
        return searchIn(_root, e, null);
    }

    /**
     * 尾递归查找
     *      O(h) 树高
     * @param v 当前（子）树根
     * @param e 目标关键码
     * @param hot 记忆热点
     * @return 查找的节点
     */
    private BinNode<T> searchIn(BinNode<T> v,T e, BinNode<T> hot) {

        // 子树为空或根节点为目标节点，直接返回
        if (v == null || e == v.data) {
            return v;
        }

        // 记录当前非空节点
        this._hot = v;

        v = (e.compareTo(v.data) < 0)? v.lChild: v.rChild;

        return searchIn(v, e, hot);
    }

    /**
     * 插入算法
     * @param e
     * @return
     */
    public BinNode<T> insert(T e) {
        BinNode<T> x = this.search(e);
        if (x == null) {
            x = new BinNode<>(e, _hot);
            _size ++;
            updateHeightAbove(x);
        }
        return x;
    }

    /**
     * 删除算法
     * @param e 待删除元素
     * @return 是否删除
     */
    public boolean remove(T e) {
        // 定位目标节点
        BinNode<T> x = this.search(e);
        if (x == null) {
            // 目标不存在，此时 _hot 为 x 节点的父亲节点
            return false;
        }
        this.removeAt(x, _hot);

        // 更新大小与树高
        _size --;
        updateHeightAbove(_hot);
        return true;
    }

    public BinNode<T> removeAt(BinNode<T> x, BinNode<T> hot) {
        // 实际要被删除的节点
        BinNode<T> w = x;
        // 实际被删除节点的替代者
        BinNode<T> succ = null;

        if (!hasLChild(x)) {
            // 左子树为空
            x = x.rChild;
            succ = x;
        } else if (!hasRChild(x)) {
            // 右子树为空
            x = x.lChild;
            succ = x;
        } else {
            // 左右子树均存在
            w = w.succ();

            // swap
            T t = w.data;
            w.data = x.data;
            x.data = t;

            BinNode<T> u = w.parent;
            if (u == x) {
                succ = w.rChild;
                u.rChild = succ;
            } else {
                succ = w.rChild;
                u.lChild = succ;
            }

        }

        // 记录被删除节点的父节点
        hot = w.parent;

        // 将被删除节点的替代者与 hot 相连
        if (succ != null) {
            succ.parent = hot;
        }

        return succ;
    }

}
