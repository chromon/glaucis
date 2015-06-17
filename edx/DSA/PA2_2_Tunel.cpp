/*
描述
现有一条单向单车道隧道，每一辆车从隧道的一端驶入，另一端驶出，不允许超车

该隧道对车辆的高度有一定限制，在任意时刻，管理员希望知道此时隧道中最高车辆的高度是多少

现在请你维护这条隧道的车辆进出记录，并支持查询最高车辆的功能

输入
第一行仅含一个整数，即高度查询和车辆出入操作的总次数n

以下n行，依次这n次操作。各行的格式为以下几种之一：

1. E x		//有一辆高度为x的车进入隧道（x为整数）
2. D		//有一辆车离开隧道
3. M		//查询此时隧道中车辆的最大高度
输出
若D和M操作共计m次，则输出m行

对于每次D操作，输出离开隧道车辆的高度

对于每次M操作，输出所查询到的最大高度

样例
Input

9
E 5
E 6
M
E 2
M
D
M
D
M
Output

6
6
5
6
6
2

限制
0 ≤ n ≤ 2,000,000

0 ≤ x ≤ 231 - 1

保证车辆的进出序列是合法的

时间：2 sec

空间：256 MB

提示
如何由多个栈来模拟一个队列？可参考第四章末尾的某习题。

如何实现一个能够高效获取最大值的栈？

如何实现一个可以高效获取最大值的队列？

可参考第04章XA节的讲义以及《习题解析》的[10-19]题、[10-20]题
*/

#include <iostream>
using namespace std;

template<typename T>  
class Stack { 
private: 
	T a[10000]; 
	//T a[500000];
    int _size; 
public: 
    Stack() { 
        _size = -1; 
    } 
    
    void push(const T &e) {  
        a[++_size] = e; 
    } 

    T pop() {  
		T e = a[_size];
        _size--;
		return e;
    } 
    
	T top() { 
        return a[_size]; 
    } 

    int size() { 
        return _size+1; 
    } 

    bool empty() { 
        return (_size == -1)? true: false;
    } 
}; 

template<typename T>  
class ExtendStack { 
private :
	Stack<T> s;
	Stack<T> p;
public :
    void push(const T &e) {  
		s.push(e);
		if(!p.empty()) {
			p.push(max(e, p.top()));
		}else {
			p.push(e);
		}
    } 
	
	T pop() {
		T e = s.pop();
		p.pop();
		return e;
	}

	T top() { 
        return s.top(); 
    } 

    bool empty() { 
		return s.empty();
    } 

	T stackMax() {
		return p.top();
	}

	T max(const T &a, const T &b) {
		return a>b ? a : b;
	}
};

template<typename T> 
class ExtendQueue {
private :
	ExtendStack<T> s1;
	ExtendStack<T> s2;
public :
	void enqueue(const T &e) {
		s2.push(e);
	}

	T dequeue() {
		if(s1.empty()) {
			while(!s2.empty()) {
				s1.push(s2.pop());
			}
		}
		return s1.pop();
	}

	T queueMax() {
		if (s1.empty()) { 
            return s2.stackMax();  
		} else if (s2.empty()) { 
            return s1.stackMax();  
		} else { 
            return max(s1.stackMax(), s2.stackMax());
		}
	}

    bool empty() { 
		return s1.empty() && s2.empty();
    } 

	T max(const T &a, const T &b) {
		return a>b ? a : b;
	}
};

//int main() {
	
	//Stack<int> s; 
	//s.push(11); 
	//s.push(22); 
	//printf("%d", s.top());
	//printf("%d", s.size());
	//s.pop();
	//printf("%d", s.size());
	//printf("%d", s.pop());
	//cout<<s.size();

	
	//ExtendStack<int> s;
	//s.push(3);
	//s.push(4);
	//printf("%d", s.top());
	//s.push(5);
	//int e = s.pop();
	//printf("%d", s.stackMax());
	//printf("%d", e);

	
	//ExtendQueue<int> q;
	//q.enqueue(5);
	//q.enqueue(3);
	//int e = q.dequeue();
	//printf("%d", e);
	//q.enqueue(4);
	//printf("%d", q.queueMax());

//	ExtendQueue<int> q;
//	int n;
//	cin>>n;
//	for(int i = 0; i < n; i++) {
//		char a;
//		int x = 0;
//		cin>>a;
//		switch (a) {
//			case'E':
//				cin>>x;
//				q.enqueue(x);
//				break;
//			case 'D':
//				cout<<q.dequeue()<<endl;
//				break;
//			case 'M':
//				cout<<q.queueMax()<<endl;
//				break;
//		}
//
//	}
//		return 0;
//}