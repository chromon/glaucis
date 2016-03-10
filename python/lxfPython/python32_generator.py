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
#fib(10)

def fib0(max) :
	n, temp, a, b = 0, 0, 0, 1
	while n < max :
		print(b)
		temp = a
		a = b
		b = temp + b
		n = n + 1
	return 'done' 
fib0(10)

def fib1(n):
	if n == 0:
		return 0
	elif n == 1:
		return 1
	else:
		return fib1(n - 1) + fib1(n - 2)
#print(fib1(10))

def fib2(max) :
	if max <= 1:
		return max
	else :
		return fib2(max - 1) + fib2(max - 2)
#print(fib2(10))

def fib3(max) : 
	n, a, b = 0, 0, 1
	while n < max :
		yield(b)
		a, b = b, a + b
		n = n + 1
	return 'done'
for i in fib3(10) :
	print(i)