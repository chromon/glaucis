# -*- coding: utf-8 -*-

def _private1(name) :
	print('Hello %s!' % name)

def _private2(name) :
	print('Hi %s!' % name)

def greeting(name) :
	if len(name) > 3 :
		_private1(name)
	else :
		_private2(name)

greeting('Ellery')
greeting('ELO')