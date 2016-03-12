# -*- coding: utf-8 -*-

import functools

def now() :
	print('2016-03-12')

f = now
f()

print(f.__name__)
print(now.__name__)

def log(func) :
	@functools.wraps(func)
	def wrapper(*args, **kw) :
		print('call %s()' % func.__name__)
		return func(*args, **kw)
	return wrapper

def log2(text) :
	def decorator(func) :
		@functools.wraps(func)
		def wrapper(*args, **kw) :
			print('%s %s().' % (text, func.__name__))
			return func(*args, **kw)
		return wrapper
	return decorator

#@log
@log2('execute')
def now2() :
	print('22:05')

#now2()
#fn = log(now2)
#fn()

now2()
fn = log2('execute')(now2)
print(fn.__name__)
fn()