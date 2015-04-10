/*
	序列Hailstone(n):
		1. 当 n<=1 时，Hailstone(n) = 1;
		2. 当 n 为偶数时， Hailstone(n) = {n} U Hailstone(n/2);
		3. 当 n 为奇数时， Hailstone(n) = {n} U Hailstone(3n+1);
*/
#include <iostream>

using namespace std;

int hailstone(int n) {
	int length = 0;
	if(n <= 1) {
		return 1;
	}else {
		cout<<n<<" ";
		while(n > 1) {
			n%2 ? n = 3*n + 1: n = n/2;
			cout<<n<<" ";
			length ++;
		}
	}
	cout<<"\n";
	return length;
}

int main() {

	int a = hailstone(7);
	cout<<"Hailstone sequence count:"<<a<<endl;
	return 0;
}
