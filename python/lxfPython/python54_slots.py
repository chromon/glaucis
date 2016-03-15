# -*- coding: utf-8 -*-

from types import MethodType

class Student() :
	__slots__ = ('name', 'age')

s = Student() 
s.name = 'ellery' 
print(s.name)

def set_age(self, age) :
	self.age = age

s.set_age = MethodType(set_age, s)
s.set_age(28) 
print(s.age)

#s2 = Student()
#s2.set_age(23)
#print(s2.age)

Student.set_age = MethodType(set_age, Student)
s2 = Student()
s2.set_age(23)
print(s2.age)

s.score = 100
print(s.score)