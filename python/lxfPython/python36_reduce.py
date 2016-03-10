# -*- coding: utf-8 -*-

from functools import reduce

def add(x, y) :
	return x + y

print(reduce(add, list(range(101))))

def fn(x, y) :
	return x*10 + y

print(reduce(fn, [1, 3, 5, 7, 9]))