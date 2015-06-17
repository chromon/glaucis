/*
描述
某列车调度站的铁道联接结构如Figure 1所示。

其中，A为入口，B为出口，S为中转盲端。所有铁道均为单轨单向式：列车行驶的方向只能是从A到S，再从S到B；另外，不允许超车。因为车厢可在S中驻留，所以它们从B端驶出的次序，可能与从A端驶入的次序不同。不过S的容量有限，同时驻留的车厢不得超过m节。

设某列车由编号依次为{1, 2, ..., n}的n节车厢组成。调度员希望知道，按照以上交通规则，这些车厢能否以{a1, a2, ..., an}的次序，重新排列后从B端驶出。如果可行，应该以怎样

的次序操作?

输入
共两行。

第一行为两个整数n，m。

第二行为以空格分隔的n个整数，保证为{1, 2, ..., n}的一个排列，表示待判断可行性的驶出序列{a1，a2，...，an}。

输出
若驶出序列可行，则输出操作序列，其中push表示车厢从A进入S，pop表示车厢从S进入B，每个操作占一行。

若不可行，则输出No。

样例
Input
5 5
3 1 2 4 5

Output
No

限制
1 ≤ n ≤ 1,600,000

0 ≤ m ≤ 1,600,000

时间：2 sec

空间：256 MB
*/
#include <iostream>
#include <string>

using namespace std;

class MyStack {
public:
	int stack[16000001];

	int size;

	void push(int e) {
		stack[size + 1] = e;
		size++;
	}

	int pop() {
		int e = stack[size];
		stack[size] = 0;
		size--;
		return e;
	}

	int top() {
		int e = stack[size];
		return e;
	}

	bool empty() {
		return (size == -1)? true: false;
	}
};

int main() {
	int n, m;
	int size = -1;
	MyStack a, s, b;
	a.size = size;
	b.size = size;
	s.size = size;
	cin>>n>>m;
	for(int i=0; i<n; i++) {
		cin>>a.stack[i];
	}

/*
	5 5         b=1 2 3 4 5
				a=3 2 4 1 5
				a=3 1 2 4 5
	s= 
	j=4
*/
	

	return 0;
}