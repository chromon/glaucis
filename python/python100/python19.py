# -*- coding: utf-8 -*-

'题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。'

from functools import reduce

def func(n) :
    l = [1,]

    for k in range(2, n + 1) :
        while n != k :
            if n % k == 0 :
                l.append(k)
                n = n // k
            else :
                break
    l.append(n)
    print(l)
    s = reduce(lambda x, y : x + y, l)
    print(s)
    if s == n :
        print(n)

#func(6)

for i in range(1, 1001) :
    func(i)
