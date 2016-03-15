# -*- coding: utf-8 -*-

class Student() :
	def get_score(self) :
		return self.get_score

	def set_score(self, score) :
		if not isinstance(score, int) :
			raise ValueError('score must be a integer!')
		if score < 0 or score > 100 :
			raise ValueError('score must between 0 to 100!')
		self.score = score

s = Student()
s.set_score(101)
print(s.get_score())
