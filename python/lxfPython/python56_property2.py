# -*- coding: utf-8 -*-

class Student():
    @property
    def score(self) :
        return self._score
    
    @score.setter
    def score(self, score) :
        if not isinstance(score, int) :
            raise ValueError('score must be a integer!')
        if score < 0 or score > 100 :
            raise ValueError('score must between 0 to 100!')
        self._score = score

s = Student()
s.score = 100
print(s.score)

class Person() :
    @property
    def birth(self):
        return self._birth

    @birth.setter
    def birth(self, year) :
        self._birth = year

    @property
    def age(self):
        return 2016 - self.birth
    
p = Person()
p.birth = 1986
print(p.age)