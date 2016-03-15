# -*- coding: utf-8 -*-

class Student(object) :
    def __init__(self, name) :
        self.name = name

    def __str__(self) :
        return 'Student Object (name: %s)' % self.name

print(Student('ellery'))
s = Student('bloblo')
print(s)