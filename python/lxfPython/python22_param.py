# -*- coding: utf-8 -*-

def power(x) :
	return x*x

print(power(3))

def power2(x, n):
	s = 1
	while n > 0:
		n = n -1
		s *= x
	return s

print(power2(2, 5))

def power3(x, n=2) :
	s = 1
	while n > 0 :
		n -= 1
		s *= x
	return s

print(power3(2))
print(power3(2, 5))

def enroll(name, gender, age=6, city='HL') :
	print('name=', name)
	print('gender=', gender)
	print('age=', age)
	print('city=', city)

print(enroll('ellery', 'male'))
print(enroll('bauble', 'male', age=7))

def addend(l=[]) :
	l.append('end')
	return l

print(addend([1, 2, 3]))
print(addend())
print(addend())
