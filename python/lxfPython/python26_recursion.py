# -*- coding : utf-8 -*-

def fact(n) :
	s = 1
	while n > 0 :
		s *= n
		n -= 1
	return s

print(fact(5))

def fact2(n) :
	if n == 1 :
		return n
	else :
		return n * fact2(n-1)

print(fact2(5))