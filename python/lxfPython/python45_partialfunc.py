# -*- coding: utf-8 -*-

import functools

print(int('123', base=8))
print(int('abcd', base=16))
print(int('1111', base=2))

def int2(x, base=2) :
	return int(x, base)
print(int2('1111'))

int3 = functools.partial(int, base=2)
print(int3('1111'))