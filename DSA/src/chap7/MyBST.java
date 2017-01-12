package chap7;

import chap5.*;

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
        hot = v;

        v = (e.compareTo(v.data) < 0)? v.lChild: v.rChild;

        return searchIn(v, e, hot);
    }

    public BinNode<T> insert(T e) {
        BinNode<T> x = this.search(e);
        if (x == null) {
            x = new BinNode<T>(e, _hot);
            _size ++;
            updateHeightAbove(x);
        }
    }
}
