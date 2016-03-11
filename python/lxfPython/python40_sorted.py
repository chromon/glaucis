# -*- coding: utf-8 -*-

li = [3, -22, 18, 93, -49, 2]
print(sorted(li))
print(sorted(li, key=abs))
print(sorted(li, reverse=True))

l = [('Bob', 75), ('Adam', 92), ('Bart', 66), ('Lisa', 88)]

def by_name(t) :
	return t[0].lower()

L2 = sorted(l, key=by_name)
print(L2)

def by_score(t) :
	return t[1]

L3 = sorted(l, key=by_score, reverse=True)
print(L3)