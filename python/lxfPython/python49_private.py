# -*- coding: utf-8 -*-

class Student(object) :
	def __init__(self, name, age, score) :
		self.__name = name
		self.__age = age
		self.__score = score

	def get_name(self) :
		return self.__name

	def set_name(self, name) :
		self.__name = name

	def print_score(self) :
		print('name=%s, age=%s, score=%s' % (self.__name, self.__age, self.__score))

e = Student('ellery', 28, 100)
e.print_score()

e.set_name('bauble')
print(e.get_name())
