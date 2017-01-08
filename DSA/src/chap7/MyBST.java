package chap7;

import chap5.MyBinTree;

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

}
