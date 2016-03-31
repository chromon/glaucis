# -*- coding: utf-8

'题目：斐波那契数列。'

def fib(x) :
    if x == 0 :
        return 1
    elif x == 1 :
        return 1
    else :
        return fib(x - 1) + fib(x - 2)

print(fib(5))