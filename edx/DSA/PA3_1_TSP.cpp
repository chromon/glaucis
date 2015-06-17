/*
描述
Shrek是一个大山里的邮递员，每天负责给所在地区的n个村庄派发信件。但杯具的是，由于道路狭窄，年久失修，村庄间的道路都只能单向通过，甚至有些村庄无法从任意一个村庄到达。这样我们只能希望尽可能多的村庄可以收到投递的信件。

Shrek希望知道如何选定一个村庄A作为起点（我们将他空投到该村庄），依次经过尽可能多的村庄，路途中的每个村庄都经过仅一次，最终到达终点村庄B，完成整个送信过程。这个任务交给你来完成。

输入
第一行包括两个整数n，m，分别表示村庄的个数以及可以通行的道路的数目。

以下共m行，每行用两个整数v1和v2表示一条道路，两个整数分别为道路连接的村庄号，道路的方向为从v1至v2，n个村庄编号为[1, n]。

输出
输出一个数字，表示符合条件的最长道路经过的村庄数。

样例
Input
4 3
1 4
2 4
4 3

Output
3

限制
1 ≤ n ≤ 1,000,000

0 ≤ m ≤ 1,000,000

输入保证道路之间没有形成环

时间：2 sec

空间：256 MB

提示
拓扑排序
*/

#include <cstdio>
#include <cstdlib>
#define MAXNUM 1000005
 
template<typename Comparable>
class Stack
{
private:
    int _size;
    Comparable *_elem;
    int _capacity;
public:
    Stack(int c = 1000005, int s = 0, Comparable v = 0)
    {
        _elem = new Comparable[_capacity = c];
        for(_size = 0; _size < s; _elem[_size++] = v);
    }
    
    void insert(int r, const Comparable  &e)
    {
        for (int i = _size; i > r; i--)
            _elem[i] = _elem[i - 1];
        _elem[r] = e;
        _size++;
    }
    int size() const
    {return _size;}
    
    int remove( int lo, int hi )
    {
        //返回删除元素的数目，区间为[lo, hi)
        if (lo == hi) return 0;
        while (hi < _size)
            _elem[lo++] = _elem[hi++];
        _size = lo;
        return hi - lo;
    }
    
    void  remove(int r)
    {
        remove(r, r+1);
    }
    
    bool isempty() const {return !_size;}
    void push ( Comparable const& e ) { insert ( size(), e ); }
    void pop() { return remove ( size() - 1 ); }
    Comparable top() { return _elem[size() - 1];}
};
 
typedef int vertexData;
int maxRoad=1;
 
typedef struct edge
{
    int direction;
    edge *nextEdge;
}edge;
 
typedef struct vertexNode
{
    vertexData data;
    int indegree;
    int numOfValages;
    edge *firstEdge;
}vertexNode;
 
typedef struct adjMatrix
{
    vertexNode vertexNodes[MAXNUM];
    int vertexNum, edgeNum;
 
}adjMatrix;
 
void createGraph(adjMatrix *g)
{
    int start, end;
    scanf("%d", &g->vertexNum);
    scanf("%d", &g->edgeNum);
    for (int i = 1; i <= g->vertexNum; i++)
    {
        g->vertexNodes[i].data = i;
        g->vertexNodes[i].numOfValages = 1;
        g->vertexNodes[i].indegree = 0;
        g->vertexNodes[i].firstEdge = NULL;
    }
    
    for (int i = 1; i <= g->edgeNum; i++)
    {
        scanf("%d", &start);
        scanf("%d", &end);
        edge *q = new edge;
        q->direction = end;
        q->nextEdge = g->vertexNodes[start].firstEdge;
        g->vertexNodes[start].firstEdge = q;
        g->vertexNodes[end].indegree++;
    }
}
 
void topSort(adjMatrix *g)
{
    Stack<int> S;
    edge *p = NULL;
    
    for (int  i = 1; i <= g->vertexNum; i++)
    {
        if (g->vertexNodes[i].indegree == 0)
            S.push(g->vertexNodes[i].data);
    }
 
    while (!S.isempty())
    {
        int count = S.top();
        S.pop();
        p = g->vertexNodes[count].firstEdge;
        
        while (p != NULL)
        {
            if (--g->vertexNodes[p->direction].indegree == 0)
                S.push(p->direction);
            
            if (g->vertexNodes[count].numOfValages >= g->vertexNodes[p->direction].numOfValages)
                g->vertexNodes[p->direction].numOfValages = g->vertexNodes[count].numOfValages+1;
           
            if (maxRoad <= g->vertexNodes[p->direction].numOfValages)
                maxRoad = g->vertexNodes[p->direction].numOfValages;
            
            p = p->nextEdge;
        }
    }
}
 
 
int main(int argc, const char * argv[])
{
    adjMatrix *g = new adjMatrix;
    createGraph(g);
    topSort(g);
    
    printf("%d", maxRoad);
}