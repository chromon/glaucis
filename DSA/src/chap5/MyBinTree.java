package chap5;

/**
 * 树
 *
 * 树是特殊的图 T = (V, E)，节点数 |V| = n，边数 |E| = e
 *
 * 指定任一节点 r 作为根后，T 即称为有根树（rooted tree）
 *
 * 若：T1，T2，...Td为有根树，则：子树也是有根树
 *
 * 相对于 T，Ti 称为以 ri 为根的子树（subtree rooted at ri），记作 Ti = subtree(ri)
 *
 * ri 称作为 r 的孩子（child），ri 之间互称兄弟（sibling），r 为其父亲（parent），
 * d = degree(r) 为 r 的（出）度（degree）
 *
 * 可归纳证明：e = n - 1，故衡量相关复杂度时，可以 n 作为参照
 *
 * 若指定 Ti 作为 T 的第 i 棵子树，ri 作为 r 的第 i 个孩子，则称 T 为有序树（ordered tree）
 *
 * V 中 的 k+1 个节点，通过 E 中的 K 条边依次相连，构成一条路径（path）
 *
 * 路经长度：|π| = 边数 = K
 *
 * 环路（cycle、loop） ：Vk = V0
 *
 * 节点之间均有路径，称作连通图（connected），不含环路，称作无环图（acyclic）
 *
 * 树：  无环连通图
 *      极小连通图
 *      极大无环图
 *
 * 故：任一节点 V 与根之间存在唯一路径 path(v, r) = path(v)
 *
 * 不致歧义时，路径、节点和子树可相互指代 path(v) ~ v ~ subtree(v)
 *
 * v 的深度：depth(v)  = |path(v)|
 *
 * path(v) 上节点，均为 v 的祖先（ancestor），v 是他们的后代（descendent)
 * 其中，除自身外，是真（proper）祖先/后代
 *
 * 半线性： 在任一深度 v 的祖先若存在，必然唯一，v 的后代若存在，则未必唯一
 *
 * 根节点是所有节点的公共祖先，深度为 0
 *
 * 没有后代的节点称作叶子（leaf）
 *
 * 所有叶子节点深度中的最大者称作（子）树（根）的高度，height(v) = height(subtree(v))
 *
 * 特别地，空树的高度取作 -1
 *
 * depth(v) + height(v) <= height(T)
 *
 * 节点度数不超过 2 的树称作二叉树
 *
 * 深度为 k 的节点至多 2^k 个
 *
 * 含 n 个节点，高度为 h 的二叉树中，h < n < 2^(h + 1)
 * n = h + 1 时，退化为一条单链
 * n = 2^(h + 1) - 1 时，即所谓的满二叉树
 *
 * 真二叉树：每个节点都有 0 个或 2 个节点
 *
 * 用二叉树表示多叉树：多叉树 --> 长子兄弟表示法 --> 45度角旋转 --> 二叉树
 *
 * Created by Ellery on 2016/12/6.
 */

/**
 * 树节点类
 * @param <T>
 */

@SuppressWarnings("unchecked")
class BinNode<T extends Comparable<T>> {

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
}

/**
 * 二叉树类
 * @param <T>
 */
public class MyBinTree<T extends Comparable<T>> {

    private int _size;

    private BinNode<T> _root;

    /**
     * 二叉树规模
     * @return 节点数
     */
    public int size() {
        return this._size;
    }

    /**
     * 是否为空
     * @return 返回 true 为空
     */
    public boolean empty() {
        if (_root == null) {
            return true;
        }
        return false;
    }

    /**
     * 根节点
     * @return 返回根节点
     */
    public BinNode<T> root() {
        return this._root;
    }

    /**
     * 节点高度
     * @param p 待查询节点
     * @return 节点高度
     */
    public int stature(BinNode<T> p) {
        int h = (p != null)? p.height: -1;
        return h;
    }

    /**
     * 更新当前节点高度
     *      当前节点高度 = 左右子节点高度的最大值加 1
     * @param x 被更新节点
     * @return 返回更新后的高度
     */
    public int updateHeight(BinNode<T> x) {
        int subHeight = this.stature(x.lChild) >= this.stature(x.rChild)
                ? this.stature(x.lChild): this.stature(x.rChild);
        x.height = 1 + subHeight;
        return x.height;
    }

    /**
     * 更新节点 x 以及其祖先的高度
     * @param x 被更新的节点
     */
    public void updateHeightAbove(BinNode<T> x) {
        while (x != null) {
            this.updateHeight(x);
            x = x.parent;
        }
    }

    /**
     * 新建节点作为当前节点的右孩子插入
     * @param x 新建节点的父节点
     * @param e 新建节点内容
     * @return 新建节点
     */
    public BinNode<T> insertAsRC(BinNode<T> x, T e) {
        // 更新规模
        this._size ++;

        x.insertAsRC(e);

        return x.rChild;
    }

    /**
     * 新建节点作为当前节点的左孩子插入
     * @param x 新建节点的父节点
     * @param e 新建节点内容
     * @return 新建节点
     */
    public BinNode<T> insertAsLC(BinNode<T> x, T e) {
        // 更新规模
        this._size ++;

        x.insertAsLC(e);

        return x.lChild;
    }

    public void travLevel() {

    }

    public void travPre() {

    }

    public void travIn() {

    }

    public void travPost() {

    }
}
