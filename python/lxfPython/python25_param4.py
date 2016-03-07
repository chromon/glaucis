# -*- coding: utf-8 -*-

def f1(a, b, c=0, *args, **kw):
    print('a =', a, 'b =', b, 'c =', c, 'args =', args, 'kw =', kw)

def f2(a, b, c=0, *, d, **kw) :
	print('a', a, 'b', b, 'c', c, 'd', d, 'kw', kw)

f1(1, 2)
f1(1, 2, 3)
f1(1, 2, 3, 'a', 'b')
f1(1, 2, 3, 'a', 'b', name='haha', age=13)

f2(1, 2, c=3, d='haha', name='hehe', age=28)