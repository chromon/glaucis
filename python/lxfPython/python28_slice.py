# -*- coding: utf-8 -*-

l = ['java', 'c', 'python', 'javascript']

for i in range(3) :
	print(l[i])

print(l[0:3])
print(l[:3])
print(l[-1])
print(l[-2:])
print(l[-2:-1])

s = list(range(100))
print(s)
print(s[:10])
print(s[-10:])
print(s[10:20])
print(s[:10:2])
print(s[:10:1])
print(s[::5])
print(s[:90:-2])