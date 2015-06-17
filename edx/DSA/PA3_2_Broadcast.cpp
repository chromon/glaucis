/*
描述
某广播公司要在一个地区架设无线广播发射装置。该地区共有n个小镇，每个小镇都要安装一台发射机并播放各自的节目。

不过，该公司只获得了FM104.2和FM98.6两个波段的授权，而使用同一波段的发射机会互相干扰。已知每台发射机的信号覆盖范围是以它为圆心，20km为半径的圆形区域，因此，如果距离小于20km的两个小镇使用同样的波段，那么它们就会由于波段干扰而无法正常收听节目。现在给出这些距离小于20km的小镇列表，试判断该公司能否使得整个地区的居民正常听到广播节目。

输入
第一行为两个整数n，m，分别为小镇的个数以及接下来小于20km的小镇对的数目。 接下来的m行，每行2个整数，表示两个小镇的距离小于20km（编号从1开始）。

输出
如果能够满足要求，输出1，否则输出-1。

输入样例
4 3
1 2
1 3
2 4
输出样例
1
限制
1 ≤ n ≤ 10000

1 ≤ m ≤ 30000

不需要考虑给定的20km小镇列表的空间特性，比如是否满足三角不等式，是否利用传递性可以推出更多的信息等等。

时间：2 sec

空间：256MB

提示
BFS
*/

#include <cstdio>
#include <cstdlib>
#define MAXN 10005
class Queue
{
private:
    int *_elem;
    int _capacity;
    int head, tail;
public:
 
    Queue(int c = MAXN)
    {
        _elem = new int[_capacity = c];
        for (int i = 0; i < _capacity; _elem[i++] = 0);
        head = 1;
        tail = 0;
    }
    
    int enQueue(int n)
    {
        _elem[++tail] = n;
        return n;
    }
    
    int deQueue()
    {
        return _elem[head++];
    }
    
    bool isEmpty()
    {
        return head > tail;
    }
    
    int getFront()
    {
        return _elem[head];
    }
    
    int getBack()
    {
        return _elem[tail];
    }
};


typedef struct edge
{
    edge *nextEdge;
    int to;
}edge;

typedef struct vertexNode
{
    int status;
    edge *firstEdge;
    
    vertexNode( int s = 0, edge *p = NULL):
    status(s), firstEdge(p){}
}vertexNode;

class graph
{
private:
    vertexNode *_vertexNodes;

    int _size;
public:
    graph()
    {
        _vertexNodes = new vertexNode[MAXN];
    }
    
    void createEdge(int start, int end)
    {
        edge *q = new edge;
        q->to = end;
        q->nextEdge = _vertexNodes[start].firstEdge;
        _vertexNodes[start].firstEdge = q;
    }
    
    void setSize(int n)
    {
        _size = n;
    }
    
    int bfs(int v)
    {
        Queue queue;
        int w, r;
        r = 1;
        _vertexNodes[v].status = 1;
        queue.enQueue(v);
       
        while (!queue.isEmpty())
        {
            v = queue.getFront();
            edge *q = _vertexNodes[v].firstEdge;
            if (_vertexNodes[v].firstEdge != NULL)
            {
                w = q->to;
                while (q != NULL)
                {
                    if (_vertexNodes[w].status == 0)
                    {_vertexNodes[w].status = -_vertexNodes[v].status; queue.enQueue(w);}
                    if (_vertexNodes[v].status == _vertexNodes[w].status) r = -1;
                    q = q->nextEdge;
                    if (q !=NULL)
                        w = q->to;
                }
            }
            queue.deQueue();
        }
        return r;
    }
    
    int BFS(int n)
    {
        int result = 1;
        for (int i = 1; i <= n; i++)
        {
            if (_vertexNodes[i].status == 0)
            {
                int r = bfs(i);
                if (r == -1) {result = -1; break;}
            }
        }
        return result;
    }
};

int main(int argc, const char * argv[])
{
    int m, n;
    int start, end;
    scanf("%d %d", &n, &m);
    graph g;
    for (int i = 0; i < m; i++)
    {
        scanf("%d %d", &start, &end);
        g.createEdge(end, start);
        g.createEdge(start, end);
    }
    int result = g.BFS(n);
    printf("%d", result);
}