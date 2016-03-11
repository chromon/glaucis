# -*- coding: utf-8 -*-

def lazy_sum(*args) :
	def sum() :
		n = 0
		for i in args :
			n += i
		return n
	return sum

s = lazy_sum(3, 5)
print(s)
print(s())

def fn() :
	fs = []
	for i in range(1, 4) :
		def f() :
			return i * i
		fs.append(f)
	return fs

f1 = fn()[0]
print(f1())
f2 = fn()[1]
print(f2())
f3 = fn()[2]
print(f3())