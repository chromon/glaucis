# -*- coding: utf-8 -*-

class Fib(object) :
    def __init__(self) :
        self.a = 0
        self.b = 1

    def __iter__(self) :
        return self

    def __next__(self) :
        temp = self.a
        self.a = self.b
        self.b = self.a + temp
        if self.a > 100:
            raise StopIteration()
        return self.a

    def __getitem__(self, n) :
        for i in range(n) :
            temp = self.a
            self.a = self.b
            self.b = self.a + temp
        return self.a

f = Fib()
#for i in f:
#    print(i)

#print(f[5])
print(f[3])