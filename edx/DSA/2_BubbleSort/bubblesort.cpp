/*
	冒泡排序
*/
#include <iostream>

using namespace std;

//获得数组长度
template <class T>
int getArrayLen(T& array) {
	return (sizeof(array) / sizeof(array[0]));
}

void bubbleSort(int a[], int n) {
	for(int i = 0; i < n-1; i++) {
		for(int j = 0; j < n-1-i; j++){
			if(a[j] > a[j+1]) {
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	}
	for(int k = 0; k < n; k++) {
		cout<<a[k]<<" ";
	}
}

int main() {
	int a[10] = {22, 3, 6, 12, 54, 18, 8, 4, 11, 34};
	int n = getArrayLen(a);
	bubbleSort(a, n);
	return 0;
}