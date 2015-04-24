/*
描述
一般来说，给定二叉树的先序遍历序列和后序遍历序列，并不能确定唯一确定该二叉树。



（图一）

比如图一中的两棵二叉树，虽然它们是不同二叉树，但是它们的先序、后序遍历序列都是相同的。

但是对于“真二叉树”（每个内部节点都有两个孩子的二叉树），给定它的先序、后序遍历序列足以完全确定它的结构。

将二叉树的n个节点用[1, n]内的整数进行编号，输入一棵真二叉树的先序、后序遍历序列，请输出它的中序遍历序列。

输入
第一行为一个整数n，即二叉树中节点的个数。

第二、三行为已知的先序、后序遍历序列。

输出
仅一行，给定真二叉树的中序遍历序列。

样例
Input
5
1 2 4 5 3
4 5 2 3 1
Output
4 2 5 1 3

限制
对于95%的测例：1 ≤ n ≤ 1,000,000

对于100%的测例：1 ≤ n ≤ 4,000,000

输入的序列是{1,2...n}的排列，且对应于一棵合法的真二叉树

时间：2 sec

空间：256 MB

提示


观察左、右孩子在先序、后序遍历序列中的位置

重温视频05e5-3
*/

#include<stdio.h>

int preOrder2[4000000];
int postOrder2[4000000];

struct BinNode { 
	int data; 
	BinNode* lc; 
	BinNode* rc; 
};

//真二叉树重构
BinNode* properRebuild(int preOrder[], int postOrder[], int n) {
	//只有一个根节点
	if(n == 1) {
		BinNode* root = new BinNode();
		root->data = preOrder[0];
		root->lc = NULL;
		root->rc = NULL;
		return root;
	}

	//根节点
	BinNode* root = new BinNode();
	root->data = preOrder[0];

	//查找左右子树分界位置
	int posi;
	for(posi = 0; posi < n; posi++) {
		if(*(preOrder+1) == postOrder[posi]) {
			break;
		}
	}

	//右子树长度
	int n_temp = n - 1 - (posi + 1);

	root->lc = properRebuild(preOrder+1, postOrder, posi+1);
	root->rc = properRebuild(preOrder+1+(posi+1), postOrder+(posi+1), n_temp);

	return root;
};

//二叉树中序遍历
void travIn_R(BinNode* x) { 
	if (!x) return;
	travIn_R(x->lc);
	printf("%d ", x->data);
	travIn_R(x->rc);
};


int main() {
	int n;
    scanf("%d", &n);
	for (int i = 0; i < n; i++){
        scanf("%d", &preOrder2[i]);
	}
	for (int i = 0; i < n; i++){
        scanf("%d", &postOrder2[i]);
	}
    BinNode* b = properRebuild(preOrder2, postOrder2, n);
    travIn_R(b);
	return 0;
}
