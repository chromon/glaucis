# -*- coding: utf-8 -*-

def cals(num) :
	sum = 0
	for n in num :
		sum += n * n
	return sum

print(cals([1, 2, 3]))

def cals2(*num) :
	sum = 0
	for n in num :
		sum += n * n
	return sum

print(cals2(1, 2))
print(cals2(1, 2, 3))
print(cals2())


num = [1, 2, 3]
print(cals2(*num))