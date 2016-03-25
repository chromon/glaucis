# -*- coding: utf-8 -*-

import itertools

n = itertools.count(1)
ns = itertools.takewhile(lambda x : x < 10, n)
print(list(ns))

for i in itertools.chain('abc', 'xyz') :
    print(i)