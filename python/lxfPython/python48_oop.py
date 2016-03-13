# -*- coding: utf-8 -*-

class Student(object) :
	def __init__(self, name, age, score) :
		self.name = name
		self.age = age
		self.score = score

	def print_score(self) :
		print('name=%s, age=%s, score=%s' % (self.name, self.age, self.score))

e = Student('ellery', 20, 100)
e.print_score()

e.name='bauble'
e.age=29
e.score=98
e.print_score()