# -*- coding: utf-8 -*-

class Animal(object) :
	def run(self) :
		print('Animal is running...')

class Cat(Animal) :
	pass

class Dog(Animal) :
	def run(self, name) :
		print('%s is running...' % name)

cat = Cat()
cat.run()

dog = Dog()
dog.run('puppy')