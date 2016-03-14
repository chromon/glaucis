# -*- coding: utf-8 -*-

class Student() :
	def __init__(self, name, age) :
		self.name = name
		self.age = age

	def print_info(self) :
		print('name=%s, age=%s' % (self.name, self.age))

s = Student('ellery', 28)

print(hasattr(s, 'name'))
print(getattr(s, 'name'))
setattr(s, 'name', 'python')
print(getattr(s, 'name'))

print(hasattr(s, 'print_info'))
print(getattr(s, 'print_info'))
f = getattr(s, 'print_info')
print(f)
f()