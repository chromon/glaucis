# -*- coding: utf-8 -*-

def person(name, age, **kw) :
	print('name', name, 'age', age, 'other', kw)

person('ellery', 18)
person('hello', 33, city='beijing', job='engineer')

d = {'city': 'hl', 'job': 'software engineer'}
person('world', 28, **d)

def human(name, age, *, city, job): 
	print('name', name, 'age', age, 'other', city, job)

human('p', 18, city='sh', job='worker')