# -*- coding: utf-8 -*-

class Student(object) :
    def __init__(self, name) :
        self.name = name

    def __getattr__(self, attr) :
        if attr == 'score' :
            return 'there is no attribute named \'score\''

s = Student('ellery')
print(s.name)
print(s.score)
print(s.abc)