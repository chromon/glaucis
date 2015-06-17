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

struct BinNode{
    int data;
    BinNode *lChild;
    BinNode *rChild;
};

BinNode* reBuildTree(int preOrder[], int postOrder[], int length){
    if (length == 1){
        BinNode *T = new BinNode;
        T->data = preOrder[0];
        T->lChild = NULL;
        T->rChild = NULL;
        return T;
    }
    BinNode *T = new BinNode;
    T->data = preOrder[0];
    
    int pos = 0;
    for (; pos < length; pos ++){
        if (postOrder[pos] == *(preOrder + 1))
            break;
    }
    
    int l2 = length-1-(pos + 1);

    T->lChild = reBuildTree(preOrder+1, postOrder, pos + 1);
    T->rChild = reBuildTree(preOrder+1+(pos+1), postOrder+pos+1, l2);
    return T;
}

void inTraverse(BinNode * T){
    if (!T) return;
    inTraverse(T->lChild);
    printf("%d ", T->data);
    inTraverse(T->rChild);
}
int preOrder1[4000000];
int postOrder1[4000000];
/*
int main(){

    int n;
    scanf("%d", &n);
	for (int i = 0; i < n; i++){
        scanf("%d", &preOrder1[i]);
	}
	for (int i = 0; i < n; i++){
        scanf("%d", &postOrder1[i]);
	}
    BinNode *T = reBuildTree(preOrder1, postOrder1, n);
    inTraverse(T);
}*/