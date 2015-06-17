/*
描述
某高性能计算集群（HPC cluster）采用的任务调度器与众不同。为简化起见，假定该集群不支持多任务同时执行，故同一时刻只有单个任务处于执行状态。初始状态下，每个任务都由称作优先级数的一个整数指定优先级，该数值越小优先级越高；若优先级数相等，则任务名ASCII字典顺序低者优先。此后，CPU等资源总是被优先级数最小的任务占用；每一任务计算完毕，再选取优先级数最小下一任务。不过，这里的任务在计算结束后通常并不立即退出，而是将优先级数加倍（加倍计算所需的时间可以忽略）并继续参与调度；只有在优先级数不小于2^32时，才真正退出

你的任务是，根据初始优先级设置，按照上述调度原则，预测一批计算任务的执行序列。

输入
第一行为以空格分隔的两个整数n和m，n为初始时的任务总数，m为所预测的任务执行序列长度，每行末尾有一个换行符

以下n行分别包含一个整数和一个由不超过8个小写字母和数字组成的字符串。前者为任务的初始优先级数，后者为任务名。数字和字符串之间以空格分隔

输出
最多m行，各含一个字符串。按执行次序分别给出执行序列中前m个任务的名称，若执行序列少于m，那么输出调度器的任务处理完毕前的所有任务即可。

样例
Input
3 3
1 hello
2 world
10 test

Output
hello
hello
world

限制
0 ≤ n ≤ 4,000,000

0 ≤ m ≤ 2,000,000

0 < 每个任务的初始优先级 < 2^32

不会有重名的任务

时间：2 sec

内存：512 MB

提示
优先级队列
*/
#include <cstdio>
#include <cstdlib>
#include <cstring>

#define MAXN 10000005
#define  InHeap(n, i)      ( ( ( -1 ) < ( i ) ) && ( ( i ) < ( n ) ) )
#define  Parent(i)         ( ( i - 1 ) >> 1 )
#define  LastInternal(n)   Parent( n - 1 )
#define  LChild(i)         ( 1 + ( ( i ) << 1 ) )
#define  RChild(i)         ( ( 1 + ( i ) ) << 1 )
#define  ParentValid(i)    ( 0 < i )
#define  LChildValid(n, i) InHeap( n, LChild( i ) )
#define  RChildValid(n, i) InHeap( n, RChild( i ) )
#define  Smaller(PQ, i, j)  (  (PQ[i]) < (PQ[j])  ? (i) : (j) )
#define  ProperParent(PQ, n, i) \
( RChildValid(n, i) ? Smaller( PQ, Smaller( PQ, i, LChild(i) ), RChild(i) ) : \
( LChildValid(n, i) ? Smaller( PQ, i, LChild(i) ) : i ))


const int SZ = 1<<19;
struct fastio
{
    char inbuf[SZ];char outbuf[SZ];fastio()
    {
        setvbuf(stdin,inbuf,_IOFBF,SZ);
        setvbuf(stdout,outbuf,_IOFBF,SZ);
    }
}io;

struct Node
{
    long long priority;
    char name[10];
    
    bool operator < (const Node &a)
    {
        if (priority < a.priority)
            return true;
        else if (priority == a.priority)
        {
            int temp = 0;
            while (name[temp] == a.name[temp])
            {
                temp++;
            }
            if (name[temp] < a.name[temp])
                return true;
        }
        return false;
    }
};

void swap(Node &a, Node &b)
{
    Node temp = a;
    a = b;
    b = temp;
}

int percolateDown(int n, int i, Node *_elem)
{
    int j;
    j = ProperParent(_elem, n ,i);
    while (i != j)
    {
        swap(_elem[i], _elem[j]);
        i = j;
        j = ProperParent(_elem, n ,i);
    }
    
    return i;
}

void heapify(int n, Node *_elem)
{
    for ( int i = LastInternal ( n ); InHeap ( n, i ); i-- )
        percolateDown(n, i, _elem);
}
Node task[MAXN];
int main()
{
    int n, m;
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++)
    {
        scanf("%lld %s", &task[i].priority, &task[i].name);
    }
    heapify(n, task);
    int count_1 = 0;
    int size = n;
    while (size > 0 && count_1 < m)
    {
        printf("%s\n", task[0].name);
        count_1++;
        task[0].priority = task[0].priority * 2;
        if (task[0].priority >= 4294967296)
        {
            swap(task[0], task[size-1]);
            size--;
        }
        percolateDown(size, 0, task);
    }
}