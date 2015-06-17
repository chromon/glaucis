/*
描述
祖玛是一款曾经风靡全球的游戏，其玩法是：在一条轨道上初始排列着若干个彩色珠子，其中任意三个相邻的珠子不会完全同色。此后，你可以发射珠子到轨道上并加入原有序列中。一旦有三个或更多同色的珠子变成相邻，它们就会立即消失。这类消除现象可能会连锁式发生，其间你将暂时不能发射珠子。

开发商最近准备为玩家写一个游戏过程的回放工具。他们已经在游戏内完成了过程记录的功能，而回放功能的实现则委托你来完成。

游戏过程的记录中，首先是轨道上初始的珠子序列，然后是玩家接下来所做的一系列操作。你的任务是，在各次操作之后及时计算出新的珠子序列。

输入
第一行是一个由大写字母'A'~'Z'组成的字符串，表示轨道上初始的珠子序列，不同的字母表示不同的颜色。

第二行是一个数字n，表示整个回放过程共有n次操作。

接下来的n行依次对应于各次操作。每次操作由一个数字k和一个大写字母Σ描述，以空格分隔。其中，Σ为新珠子的颜色。若插入前共有m颗珠子，则k ∈ [0, m]表示新珠子嵌入之后（尚未发生消除之前）在轨道上的位序。

输出
输出共n行，依次给出各次操作（及可能随即发生的消除现象）之后轨道上的珠子序列。

如果轨道上已没有珠子，则以“-”表示。

样例
	Input:
		ACCBA
		5
		1 B
		0 A
		2 B
		4 C
		0 A
	Output:
		ABCCBA
		AABCCBA
		AABBCCBA
		-
		A

限制
0 ≤ n ≤ 10^4

0 ≤ 初始珠子数量 ≤ 10^4

时间：2 sec

内存：256 MB

提示
列表
*/

#include <stdio.h>
#include "string.h"
#include <stdlib.h>

typedef struct Node {
	char data;
	struct Node *pred;
	struct Node *succ;
}List, *MyList;

// 创建头尾节点
MyList head = (MyList)malloc(sizeof(List));
MyList tail = (MyList)malloc(sizeof(List));

//初始化
void init(char *a, int n) {

	head->pred = NULL;
	head->succ = tail;
	head->data = '-';
	tail->pred = head;
	tail->succ = NULL;
	tail->data = '-';

	MyList p = head;

	for(int i=0; i<n; i++) {
		 MyList node  = new Node();
		 node->data = a[i];
		 node->pred = p;
		 node->succ = p->succ;
		 p->succ->pred = node;
		 p->succ = node;
		 p = node;
	}
}

// 将节点插入到第index位置之前
int insert(int k, char t) {
	int i = -1;
	MyList p = head;
	while (i++ < k) {
		p = p->succ;
	}

	MyList node = (MyList)malloc(sizeof(List));
	node->data = t;
	node->pred = p->pred;
	node->succ = p;
	p->pred->succ = node;
	p->pred = node;

	return 0;
}
/*
  0123456789
  accde
  1 b
  abccde
		0123456789
  		AABBCCBA
		4 C
		AABBcCCBA
*/
//判断删除节点
void remove(int k) {	
	MyList p1 = NULL, p2 = NULL, p3 = NULL, p4 = NULL, p = head;
	MyList begin = head, end = tail;
	bool b = true;
	int repeat, i = -1;

	// find position
	while (i++ < k - 2) {
		p = p->succ;
	}

	//init for 'begin' and 'end'
	begin = p; 
	end = p; 
	i = 0;
	while (i++ < 4 && end->succ != tail) {
		end = end->succ;
	}

	while (b && p != tail) {
		b = false; 
		repeat = 1;
		while (p != end) {
			p = p->succ;

			if (p->pred->data == p->data) {
				repeat++;
			}else {
				repeat = 1;
			}

			if (repeat == 3) {
				b = true;
				if (p->data == p->succ->data) {
					repeat++;
					p = p->succ;
				}

				if (repeat == 3) {
					p3 = p; 
					p2 = p3->pred; 
					p1 = p2->pred;
					p1->pred->succ = p3->succ;
					p3->succ->pred = p1->pred;
					p = p->succ;
					delete p1; 
					delete p2; 
					delete p3;
				 } else {
					p4 = p; 
					p3 = p4->pred; 
					p2 = p3->pred; 
					p1 = p2->pred;
					p1->pred->succ = p4->succ;
					p4->succ->pred = p1->pred;
					p = p->succ;
					delete p1; 
					delete p2; 
					delete p3; 
					delete p4;
				 }
				break;
			}
		}

		if (b && p != tail) {
			 begin = p; 
			 i = 0;
			 while (i++ < 2 && begin->pred != head) {
				 begin = begin->pred;
			 }
			 end = p; 
			 i = 0;
			 if (i++ < 1 && end->succ != tail){
				 end = end->succ;
			 }
			 p = begin;
		 }
	}
}

// 将节点插入到第index位置之前
void display() {
	MyList p = head->succ;
	if(p == tail) {
		printf("-");
	}else {
		while(p->succ != NULL) {
			printf("%c", p->data);
			p = p->succ;
		}
	}
	printf("\n");
}

int main() {
	char a[10005];
	int n;

	scanf("%s", &a);
	init(a, strlen(a));
	scanf("%d", &n);

	for(int i=0; i<n; i++) {
		int k;
		char t;

		scanf("%d %c", &k, &t);
		insert(k, t);
		remove(k);
		display();
	}


	//scanf("%d\n", &n);


/*
	for(int i = 0; i<10; i++) {
		printf("%c", a[i]);
	}

	for(int i = 0; i<n; i++) {	
		scanf("%d\n", &k);
		printf("-%d\n", k);
	}
*/
	return 0;
}