# -*- coding: utf-8 -*- 

g = (x for x in range(1 , 11))
print(g)

for n in g:
	print(n)

def fib(max) : 
	n, a, b = 0, 0, 1
	while n < max :
		print(b)
		a, b = b, a + b
		n = n + 1
	return 'done'
fib(10)

def fib2(max) :
	if max == 1:
		return 1
	elif max == 2:
		return 1
	else :
		return fib2(n - 1) + fib2(n - 2)
print(fib2(10))