# -*- coding: utf-8 -*-

import functools

def log(*text) :
	def decorator(func) :
		@functools.wraps(func)
		def wrapper(*args, **kw) :
			if len(text) > 0 :
				print('%s %s() begin!' % (text[0], func.__name__))
				f = func(*args, **kw)
				print('%s %s() end!' % (text[0], func.__name__))
			else :
				print('Call %s() begin!' % (func.__name__))
				f = func(*args, **kw)
				print('Call %s() end!' % (func.__name__))
			return f
		return wrapper
	return decorator
	
#@log()
@log('Execute')
def time() :
	print('2016-03-12 22:34')

time()