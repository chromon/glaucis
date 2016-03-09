# -*- coding:utf-8 -*-
import os

l = list(range(1, 11))
print(l)

s = list(x*x for x in range(1, 11))
print(s)

a = list(x*x for x in range(1, 11) if x % 2 == 0)
print(a)

b = list(m+n for m in 'ABC' for n in "XYZ")
print(b)

c = list(d for d in os.listdir())
print(c)

e = {'java': 1, 'php': 2, 'python': 3}
f = list(k + '-->'+ str(v) for k, v in e.items())
print(f)

g = ['Hello', 'World', 'Hello', 'Python']
h = list(i.lower() for i in g)
print(h)