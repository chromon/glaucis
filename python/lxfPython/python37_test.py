# -*- coding : utf-8 -*-

from functools import reduce

def normalize(x) :
	return x[0].upper()+x[1:].lower()

l = list(map(normalize, ['adam', 'LISA', 'barT']))
print(l)

def prod(l) :
	return reduce(multi, l)	
def multi(x, y) :
	return x * y
print(prod([3, 5, 7, 9]))