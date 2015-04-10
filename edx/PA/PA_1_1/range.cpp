/*
描述
数轴上有n个点，对于任一闭区间 [a, b]，试计算落在其内的点数。

输入
第一行包括两个整数：点的总数n，查询的次数m。

第二行包含n个数，为各个点的坐标。

以下m行，各包含两个整数：查询区间的左、右边界a和b。

输出
对每次查询，输出落在闭区间[a, b]内点的个数。

样例
Input
5 2
1 3 7 9 11
4 6
7 12
Output
0
3

限制
0 ≤ n, m ≤ 5×105

对于次查询的区间[a, b]，都有a ≤ b

各点的坐标互异

各点的坐标、查询区间的边界a、b，均为不超过10^7的非负整数

时间：2 sec

内存：256 MB
*/
#include <stdio.h>
#include <stdlib.h>

#define L 500005 
int arr[L]; 

int compare(const void *a, const void *b) {
    int *pa = (int*)a;
    int *pb = (int*)b;
	//从小到大排序
    return (*pa )- (*pb);  
}

/*
	二分查找返回值为不大于查找元素的最大元素的下标，
	故查找左边界a时，如果a恰好被找到，则最终结果需要+1，等同于left-1。
*/
int find(int low, int high, int *arr, int key) {  
    while(low < high) {  
        int mid = (low + high) >> 1;  
        (key < arr[mid]) ? high = mid : low = mid+1;  
    }  
    return --low;  
} 

void range(int n, int m) {
	for(int i=0; i<m; i++) {
		int count = 0;
		int a, b;
		scanf("%d %d", &a, &b);
		int left = find(0, n, arr, a);
		int right = find(0, n, arr, b);
		//printf("%d %d\n", left, right);
		if(arr[left] == a && left >= 0) {
			left--;
		}
		printf("%d\n", (right-left));
	}
}

int main() {
	int n, m;
	scanf("%d %d", &n, &m); 

	for(int i=0; i<n; i++) {
		scanf("%d", &arr[i]);
	}
	//快速排序
	qsort(arr, n, sizeof(int), compare);
	//for(int i = 0; i<n; i++) {
	//	printf("%d ", arr[i]);
	//}
	range(n, m);
	return 0;
}