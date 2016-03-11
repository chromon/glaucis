# -*- coding:utf-8 -*-

def odd(n) :
	return n % 2 == 0

print(list(filter(odd, [1, 2, 3, 4, 5, 6, 7, 8, 9])))