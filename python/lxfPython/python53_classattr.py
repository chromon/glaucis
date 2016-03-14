# -*- coding: utf-8 -*-

class Student() :
	name = "student"

s = Student()

print(s.name)
print(Student.name)
s.name = 'ellery'
print(s.name)
print(Student.name)

del s.name
print(s.name)
print(Student.name)