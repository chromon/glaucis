package chap6_graph;

/**
 * 从任意顶点出发，经过所有的边一次且恰好一次的环路称为欧拉环路
 *
 * 经过每一个顶点一次且恰好一次的环路称为汉密尔顿环路
 *
 * 邻接矩阵：顶点矩阵，顶点与顶点邻接则记为 1
 *
 * 关联矩阵：顶点与边矩阵，顶点与边存在关联关系则记为 1
 *
 * Created by Ellery on 2016/12/9.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 顶点状态
 */
enum VStatus {
    UNDISCOVERED,
    DISCOVERED,
    VISITED
}

/**
 * 顶点定义
 * @param <T>
 */
class Vertex<T extends Comparable<T>> {

    // 顶点数据
    T data;

    // 入度，出度
    int inDegree, outDegree;

    // 状态
    VStatus status;

    // 顶点发现时间、访问完时间
    int dTime, fTime;

    // 在遍历树中的父节点
    int parent;

    // 在遍历树中的优先级
    int priority;

    public Vertex(T e) {
        this.data = e;
        this.inDegree = 0;
        this.outDegree = 0;
        this.status = VStatus.UNDISCOVERED;
        this.dTime = -1;
        this.fTime = -1;
        this.parent = -1;
        this.priority = Integer.MAX_VALUE;
    }
}

/**
 * 边状态
 */
enum EStatus {
    UNDETERMINED,
    TREE,
    CROSS,
    FORWARD,
    BACKWARD
}

/**
 * 边定义
 * @param <T>
 */
class Edge<T extends Comparable<T>> {

    T data;

    // 边权重值
    int weight;

    EStatus status;

    public Edge(T e, int w) {
        this.data = e;
        this.weight = w;
        this.status = EStatus.UNDETERMINED;
    }
}

/**
 * 自定义图
 * @param <T>
 */
public class MyGraph<T extends Comparable<T>> {

    // 顶点（向量）列表
    List<Vertex<T>> v;

    // 边矩阵
    List<List<Edge<T>>> e;

    public MyGraph() {
        this.v = new ArrayList<>();
        this.e = new ArrayList<>();
    }

    /**
     * 顶点数据
     * @param i 顶点序号
     * @return 顶点数值
     */
    public T vertex(int i) {
        return this.v.get(i).data;
    }

    /**
     * 入度
     * @param i 顶点序号
     * @return 返回顶点入度
     */
    public int inDegree(int i) {
        return this.v.get(i).inDegree;
    }

    /**
     * 出度
     * @param i 顶点序号
     * @return 返回顶点出度
     */
    public int outDegree(int i) {
        return this.v.get(i).outDegree;
    }

    /**
     * 顶点发现时间
     * @param i 顶点序号
     * @return 时间
     */
    public int dTime(int i) {
        return this.v.get(i).dTime;
    }

    /**
     * 顶点访问时间
     * @param i 顶点序号
     * @return 时间
     */
    public int fTime(int i) {
        return this.v.get(i).fTime;
    }

    /**
     * 顶点状态
     * @param i 顶点序号
     * @return 返回顶点状态
     */
    public VStatus status(int i) {
        return this.v.get(i).status;
    }

    /**
     * 遍历树中父节点
     * @param i 顶点序号
     * @return 父节点
     */
    public int parent(int i) {
        return this.v.get(i).parent;
    }

    /**
     * 顶点在遍历树中的优先级
     * @param i 顶点序号
     * @return 优先级
     */
    public int priority(int i) {
        return this.v.get(i).priority;
    }

    /**
     * 判断两个顶点之间是否存在边
     * @param i 顶点
     * @param j 顶点
     * @return 是否存在边
     */
    public boolean exists(int i, int j) {
        return (0 <= i) && (i < this.v.size()) && (0 <= j)
                && (j < this.v.size()) && this.e.get(i).get(j) != null;
    }

    /**
     * 对于任意的顶点 i ，依次枚举其所有的邻接顶点 j
     *
     * @param i 顶点
     * @param j 顶点
     * @return 返回一个邻接顶点
     */
    public int nextNbr(int i, int j) {
        while ((-1 < j) && !exists(i, --j));
        return j;
    }

    /**
     * 顶点 i 的第一个邻接顶点
     *      不存在的顶点 v.size（假想的哨兵）
     * @param i 顶点
     * @return 邻接顶点
     */
    public int firstNbr(int i) {
        return this.nextNbr(i, this.v.size());
    }

    /**
     * 边的数据
     * @param i 顶点
     * @param j 顶点
     * @return 边的数据
     */
    public T edge(int i, int j) {
        return e.get(i).get(j).data;
    }

    /**
     * 边的状态
     * @param i 顶点
     * @param j 顶点
     * @return 边状态
     */
    public EStatus status(int i, int j) {
        return e.get(i).get(j).status;
    }

    /**
     * 边的权重
     * @param i 顶点
     * @param j 顶点
     * @return 权重
     */
    public int weight(int i, int j) {
        return e.get(i).get(j).weight;
    }

    /**
     * 顶点 i 和顶点 j 之间插入一条权重为 w 的边
     * @param e 边
     * @param w 权重
     * @param i 顶点
     * @param j 顶点
     */
    public void insert(Edge<T> e,int w, int i, int j) {
        if (! exists(i, j)) {
            this.e.get(i).set(j, e);
            // 边由 i => j 更改出度、入度
            this.v.get(i).outDegree ++;
            this.v.get(j).inDegree ++;
        }
    }

    /**
     * 删除顶点 i 与顶点 j 之间的边
     * @param i 顶点
     * @param j 顶点
     * @return 删除的边
     */
    public Edge<T> remove(int i, int j) {

        // 备份
        Edge<T> e = this.e.get(i).get(j);

        this.e.get(i).set(j, null);

        // 边由 i => j
        this.v.get(i).outDegree --;
        this.v.get(j).inDegree --;

        return e;
    }

    /**
     * 广度优先搜索
     *      访问一个顶点后，连续访问其所有邻接顶点，相当于二叉树的层序遍历
     * @param v 起点顶点
     * @param clock 时钟
     */
    public void bfs(int v, int clock) {

        // 初始化
        Queue<Integer> q = new LinkedList<>();
        this.v.get(v).status = VStatus.DISCOVERED;
        // enqueue
        q.offer(v);

        while (! q.isEmpty()) {
            // dequeue
            v = q.poll();
            this.v.get(v).dTime = ++clock;

            // 考察 v 的每一个邻接
            for (int u = this.firstNbr(v); -1 < u; u = this.nextNbr(v, u)) {
                // 视 u 的状态分别处理
                if (VStatus.UNDISCOVERED == this.v.get(u).status) {
                    // 顶点 v 尚未被发现
                    // 处理顶点
                    this.v.get(u).status = VStatus.DISCOVERED;
                    q.offer(u);

                    // 处理边，树边
                    this.e.get(v).get(u).status = EStatus.TREE;

                    this.v.get(u).parent = v;

                }else {
                    // 顶点 v 已被发现（在队列中），或者已经访问完
                    // 归类为跨边
                    this.e.get(v).get(u).status = EStatus.CROSS;
                }
            }

            this.v.get(v).status = VStatus.VISITED;
        }
    }

    /**
     * 深度优先搜索
     *      访问一个顶点后，任选一个其邻接顶点继续执行dfs
     * @param v 起始顶点
     * @param clock 时钟
     */
    public void dfs(int v, int clock) {
        this.v.get(v).dTime = ++ clock;
        this.v.get(v).status = VStatus.DISCOVERED;

        // 枚举所有邻居
        for (int u = this.firstNbr(v); -1 < u; u = this.nextNbr(v, u)) {
           switch (this.v.get(u).status) {
               case UNDISCOVERED:
                   // u 尚未被发现，意味着支撑树可以在此扩展
                   this.e.get(v).get(u).status = EStatus.TREE;
                   this.v.get(u).parent = v;
                   this.dfs(u, clock);
                   break;
               case DISCOVERED:
                   // u 已被发现，但尚未被访问，应属于被后代指向的祖先
                   this.e.get(v).get(u).status = EStatus.BACKWARD;
                   break;
               default:
                   // u 已被访问，则视承袭关系为前向边或跨边
                   this.e.get(v).get(u).status = this.v.get(v).dTime < this.v.get(u).dTime? EStatus.FORWARD: EStatus.CROSS;
           }
        }

        this.v.get(v).fTime = ++ clock;
        this.v.get(v).status = VStatus.VISITED;
    }
}
