/*
描述
海上有许多灯塔，为过路船只照明。
如图一所示，每个灯塔都配有一盏探照灯，照亮其东北、西南两个对顶的直角区域。探照灯的功率之大，足以覆盖任何距离。灯塔本身是如此之小，可以假定它们不会彼此遮挡。
若灯塔A、B均在对方的照亮范围内，则称它们能够照亮彼此。比如在图二的实例中，蓝、红灯塔可照亮彼此，蓝、绿灯塔则不是，红、绿灯塔也不是。

现在，对于任何一组给定的灯塔，请计算出其中有多少对灯塔能够照亮彼此。

输入
共n+1行。

第1行为1个整数n，表示灯塔的总数。

第2到n+1行每行包含2个整数x, y，分别表示各灯塔的横、纵坐标。

输出
1个整数，表示可照亮彼此的灯塔对的数量。

样例
Input
3
2 2
4 3
5 1
Output
1

限制
对于90%的测例：1 ≤ n ≤ 3×105

对于95%的测例：1 ≤ n ≤ 106

全部测例：1 ≤ n ≤ 4×106

灯塔的坐标x, y是整数，且不同灯塔的x, y坐标均互异

1 ≤ x, y ≤ 10^8

时间：2 sec

内存：256 MB

提示
注意机器中整型变量的范围，C/C++中的int类型通常被编译成32位整数，其范围为[-231, 231 - 1]，不一定足够容纳本题的输出。

*/

#include <stdio.h>  
#include <stdlib.h>  
  
#define MAXN 200002  
  
typedef struct P {  
    long x;  
    long y;  
}Point;  
  
Point p[MAXN];  
long A[MAXN];  
long cunt=0;  
long L[MAXN],R[MAXN];  
const long M=999999999;  
  
//按照 x 的值从小到大将结构体排序  
int cmp(const void *a,const void *b) {  
     return (*(Point*)a).x > (*(Point*)b).x ? 1 : -1;  
}  
  
void Merge(long Left,long Middle,long Right) {  
    long n1=Middle-Left+1;  
    long n2=Right-Middle;  
  
    long i,k;  
	for(i=1;i<=n1;i++) { 
        L[i]=A[Left+i-1];
	}
	for(i=1;i<=n2;i++) {
        R[i]=A[Middle+i];
	}
  
    L[n1+1]=M;  
    R[n2+1]=M;  
  
    i=1;  
    long j=1;  
    for(k=Left;k<=Right;k++) {  
		if(L[i]<=R[j]) { 
            A[k]=L[i++];
		} else{  
            A[k]=R[j++];  
            cunt+=n1-i+1;                 //cunt为全局变量  
        }  
    }  
}  
  
void Merge_sort(long Left,long Right) {  
    long Middle;  
    if(Left<Right) {  
        Middle=(Left+Right) >> 1;   
        Merge_sort(Left,Middle);    // 二分分解左部分  
        Merge_sort(Middle+1,Right); // 二分分解有部分  
        Merge(Left,Middle,Right);   //合并两部分  
    }  
}  
  
int main() {  
    long n;  
    scanf("%d", &n);  
      
    long i;  
	for(i=0; i<n; i++) { 
        scanf("%d%d",&p[i].x,&p[i].y);  
	}
        
    //按照 x 坐标进行排序  
    qsort(p,n,sizeof(p[0]),cmp);  
  
	for(i=0;i<n;i++) { 
        A[i+1]=p[i].y;
	}
  
    Merge_sort(1,n);  
  
    long tmp=(n*(n-1)) >> 1;  
    printf("%ld\n",tmp-cunt);  
      
    return 0;  
}  
