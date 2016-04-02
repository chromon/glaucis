# -*- coding: utf-8 -*-

'题目：判断101-200之间有多少个素数，并输出所有素数。判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。 '

from math import sqrt

l = [x for x in range(101, 201)]

for i in l :
    for j in range(2, int(sqrt(i + 1)) + 1) :
        if i % j == 0 :
            l.pop(l.index(i))
            break

print(l)