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

def str2float(s):
	def fn1(x, y):
		return x * 10 + y
	def fn2(x, y):
		return x / 10 + y
	def char2num(s):
		return {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, 
				'6': 6, '7': 7, '8': 8, '9': 9}[s]
	l = s.split('.')
	print(reduce(fn2, map(char2num, l[1][::-1])))
	print(list(map(char2num, l[1][::-1])))
	return reduce(fn1, map(char2num, l[0])) + reduce(fn2, map(char2num, l[1][::-1])) / 10

print(str2float('123.456'))