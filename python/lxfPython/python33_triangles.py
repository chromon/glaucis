# -*- coding: utf-8 -*-

def triangles() :
	l = [1]
	yield l
	while True:
		l = [1] + [l[i] + l[i + 1] for i in range(len(l) - 1)] + [1]
		yield l

for n in triangles() :
	print(n)
	x = len(n)
	if x > 10:
		break