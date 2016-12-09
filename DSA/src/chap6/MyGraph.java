package chap6;

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
import java.util.List;

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
    UNDISCOVERED,
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
        this.status = EStatus.UNDISCOVERED;
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

    public T edge(int i, int j) {
        return e.get(i).get(j).data;
    }
}
