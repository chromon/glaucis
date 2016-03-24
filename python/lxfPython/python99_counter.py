# -*- coding: utf-8 -*-

from collections import Counter

c = Counter()
for i in 'FibrousDysplasiaOfBone' :
    c[i] = c[i] + 1

print(c)