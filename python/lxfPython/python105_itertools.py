# -*- coding: utf-8 -*-

import itertools

#n = itertools.count(1)
#n = itertools.cycle('ABC')
n = itertools.repeat('abc', 100)
for i in n:
    print(i)