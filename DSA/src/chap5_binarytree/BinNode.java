package chap5_binarytree;

/**
 * 树节点类
 * @param <T>
 *
 * Created by Ellery on 2017/1/12.
 */

@SuppressWarnings("unchecked")
public class BinNode<T extends Comparable<T>> {

    // 父节点
    public BinNode<T> parent;

    // 左右孩子节点
    public BinNode<T> lChild, rChild;

    public T data;

    // 树的高度
    public int height;

    /**
     * 新建节点
     * @param e 新建节点的数值
     * @param parent 新建节点的父节点
     */
    public BinNode(T e, BinNode<T> parent) {
        this.data = e;
        this.parent = parent;
    }

    /**
     * 树的规模
     * @return 树的规模
     */
    public int size() {

        // 记录自身
        int s = 1;

        if (this.lChild != null) {
            s += this.lChild.size();
        }

        if (this.rChild != null) {
            s += this.rChild.size();
        }

        return s;
    }

    /**
     * 新建节点作为当前节点的左孩子插入
     * @param e 待插入数值
     * @return 插入节点
     */
    public BinNode<T> insertAsLC(T e) {
        this.lChild = new BinNode(e, this);
        return this.lChild;
    }

    /**
     * 新建节点作为当前节点的右孩子插入
     * @param e 待插入数值
     * @return 插入节点
     */
    public BinNode<T> insertAsRC(T e) {
        this.rChild = new BinNode(e, this);
        return this.rChild;
    }

    public boolean hasLChild(BinNode<T> p) {
        if (p.lChild != null) {
            return true;
        }
        return false;
    }

    public boolean hasRChild(BinNode<T> p) {
        if (p.rChild != null) {
            return true;
        }
        return false;
    }

    /**
     * @return 返回节点的直接后继
     */
    public BinNode<T> succ() {
        // 记录后继的临时变量
        BinNode<T> s = this;
        if (this.rChild != null) {
            // 若有右孩子，则直接后继必在右子树中
            s = this.rChild;
            // 最靠左（最小）的节点
            while (hasLChild(s)) {
                s = s.lChild;
            }
        } else {
            // 否则，直接后继应是“将当前节点包含于其左子树中的最低祖先”
            // 逆向地沿右向分支，不断朝左上方移动
            while(hasRChild(s)) {
                s = s.parent;
            }
            // 最后再朝右上方移动一步，即抵达直接后继（如果存在）
            s = s.parent;
        }
        return s;
    }
}
