#include<iostream>
using namespace std;

//列表节点位置
#define ListNodePosi(T) ListNode<T>* 

//列表节点模板类（以双向链表形式实现）
template <typename T> 
struct ListNode { 
	// 成员 数值、前驱、后继
	T data; 
	ListNodePosi(T) pred; 
	ListNodePosi(T) succ; 
	//针对header和trailer的构造
	ListNode() {} 
};

//列表模板类
template <typename T> 
class List { 
private:
	//规模、头哨兵、尾哨兵
	int _size; 
	ListNodePosi(T) header; 
	ListNodePosi(T) trailer; 
protected:
	//列表创建时出始化
	void init() {
		//创建头哨兵节点
		header = new ListNode<T>; 
		//创建尾哨兵节点
		trailer = new ListNode<T>; 
		header->succ = trailer; 
		header->pred = NULL;
		trailer->pred = header; 
		trailer->succ = NULL;
		//记录规模
		_size = 0; 
	}; 
public:
	// 构造函数
	List() { 
		init();
	} 
	//将e当作首节点插入
	ListNodePosi(T) insertAsFirst (T const& e) {
		_size++; 
		ListNodePosi(T) x = new ListNode<T>; //创建新节点
		x->data = e;
		header->succ->pred = x;
		x->succ = header->succ;
		header->succ = x;
		x->pred = header;
		return x; 
	}; 
	//将e当作末节点插入
	ListNodePosi(T) insertAsLast (T const& e) {
		_size++; 
		ListNodePosi(T) x =  new ListNode<T>; //创建新节点
		x->data = e;
		trailer->pred->succ = x;
		x->pred = trailer->pred;
		x->succ = trailer;
		trailer->pred = x;
		return x;
	}; 
	//初除合法位置p处的节点，返回被删除节点
	T remove (ListNodePosi(T) p) {
		//备份待删除节点的数值（假定T类型可直接赋值）
		T e = p->data; 
		//后继、前驱
		p->pred->succ = p->succ; 
		p->succ->pred = p->pred; 
		//释放节点，更新规模
		delete p; 
		_size--; 
		//返回备份的数值
		return e; 
	}; 
	//首节点位置
	ListNodePosi(T) first() const { 
		return header->succ; 
	} 
	//末节点位置
	ListNodePosi(T) last() const { 
		return trailer->pred; 
	}
	//遍历
	void traverse() { 
		for (ListNodePosi(T) p = header->succ; p != trailer; p = p->succ) {
			//printf("%d", p->data);
			cout<<p->data<<endl;
		}
	}
	//大小
	int size() {
		return _size;
	}
};

//队列模板类（继承List原有接口）
template <typename T> 
class Queue: public List<T> { 
public: 
	//size()、empty()以及其它开放接口均可直接沿用
	void enqueue(T const& e) { 
		//入队：尾部插入
		insertAsLast (e); 
	} 
	//出队：首部初除
	T dequeue() { 
		return List<T>::remove(List<T>::first()); 
	} 
	//队首
	ListNodePosi(T) front() { 
		return List<T>::first(); 
	} 
	//队尾
	ListNodePosi(T) rear() { 
		return List<T>::last(); 
	} 
	//是否为空
	bool empty() {
		return (List<T>::size()==0) ? true : false;
	}
};

//双端队列
template <typename T> 
class Deque: public List<T> {
public:
	//读取首元素
	ListNodePosi(T) front() {
		return List<T>::first(); 
	}; 
	//读取末元素
	ListNodePosi(T) rear() { 
		return List<T>::last();
	}; 
	//将元素e插到队列前端
	void insertFront(T const& e) {
		insertAsLast(e);
	}; 
	//将元素e插到队列末端
	void insertRear(T const& e) {
		insertAsLast(e); 
	}; 
	//删除队列的首元素
	T removeFront() {
		return List<T>::remove(List<T>::first()); 
	}; 
	//删除队列的末元素
	T removeRear() {
		return List<T>::remove(List<T>::last()); 
	}; 
};

//堆队
template <typename T> 
class Queap {
private :
	Queue<int> queue;
	Deque<int> deque;
public :
	void enqueue(T const& e) { 
		queue.enqueue(e);
		deque.insertRear(e);
		for (ListNodePosi(T) p = deque.rear(); (p->pred != NULL) &&(p->data <= e); p = p->pred) {
			p->data = e;
		}
	} 
	T dequeue() { 
		T e = queue.dequeue();
		deque.removeFront();
		return e; 
	} 
	T getMax() {
		return deque.front()->data;
	}
};

/*int main() {

	//List<int> list;
	//list.insertAsFirst(11);
	//list.insertAsFirst(22);
	//list.insertAsFirst(33);
	//list.insertAsFirst(44);
	//list.insertAsLast(55);
	//list.insertAsLast(66);
	//list.remove(list.first());
	////list.remove(list.last());
	//list.traverse();
	//printf("%d", list.size());

	//Queue<int> queue;
	//queue.enqueue(11);
	//queue.enqueue(22);
	//queue.enqueue(33);
	//queue.enqueue(44);
	//printf("%d", queue.size());
	//queue.dequeue();
	//printf("%d", queue.size());
	//queue.traverse();

	//Deque<int> deque;
	//deque.insertAsFirst(11);
	//deque.insertAsFirst(22);
	//deque.insertAsFirst(33);
	//deque.insertAsFirst(44);
	//deque.insertAsLast(55);
	//printf("%d", deque.rear()->data);
	//printf("%d", deque.size());
	//deque.removeFront();
	//deque.traverse();
	//printf("%d", deque.size());
	//deque.removeRear();
	//printf("%d", deque.size());
	//deque.traverse();

	Queap<int> q;

	int n;
	cin>>n;
	for(int i = 0; i < n; i++) {
		char a;
		int x = 0;
		cin>>a;
		switch (a) {
			case'E':
				cin>>x;
				q.enqueue(x);
				break;
			case 'D':
				cout<<q.dequeue()<<endl;
				break;
			case 'M':
				cout<<q.getMax()<<endl;
				break;
		}

	}

	return 0;
}
*/