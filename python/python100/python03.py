# -*- coding: utf-8 -*-

'题目：一个整数，它加上100后是一个完全平方数，再加上268又是一个完全平方数，请问该数是多少？'

import math

for x in range(10000) :
    a = int(math.sqrt(x + 100))
    b = int(math.sqrt(x + 268))

    if a * a == x + 100 and b * b == x + 268 :
        print(x)