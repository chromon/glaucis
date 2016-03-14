# -*- coding : utf-8 -*-

import types

class Cat() :
	def run() :
		print('cat running')
c = Cat()

print(type(123))
print(type('abc'))
print(type(map))
print(type(abs))
print(type(c))

def fn() :
	pass

print(type(fn) == types.FunctionType)
print(type(abs) == types.BuiltinFunctionType)
print(type(lambda x: x+1) == types.LambdaType)
print(type((x for x in range(10))) == types.GeneratorType)
print(type([1, 2, 3, 4, 5]) == types.GeneratorType)
print(type([1, 2, 3, 4, 5]))
print(type([1, 2, 3, 4, 5]) == types.BuiltinFunctionType)