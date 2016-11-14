# -*- coding: utf-8 -*-

import math

n = int(input())

s = str(math.factorial(n))

count = len(s);

if count <= 1000 :
    print(s)
else :
    i = 0
    while i < (count // 1000) * 1000:
        print(s[i: i + 1000])
        i += 1000

    print(s[(count // 1000) * 1000:])