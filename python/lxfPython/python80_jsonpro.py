# -*- coding: utf-8 -*-

import json

class Student(object) :
    def __init__(self, name, age) :
        self.name = name
        self.age = age

def student2dict(student) :
    return {
            'name' : student.name,
            'age' : student.age
            }

s = Student('ellery', 20)
print(json.dumps(s, default=student2dict))
print(json.dumps(s, default=lambda x : x.__dict__))

def dict2student(d) :
    return Student(d['name'], d['age'])

json_str = '{"age": 20, "name": "ellery"}'
print(json.loads(json_str, object_hook=dict2student))