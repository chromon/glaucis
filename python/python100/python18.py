# -*- coding: utf-8 -*-

'题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)'

from functools import reduce

tn = 0
sn = []

n = 3
a = 2

for i in range(3) :
    tn = tn + a
    a = a * 10
    sn.append(tn)

s = reduce(lambda x, y : x + y, sn)
print(s)
