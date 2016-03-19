# -*- coding: utf-8 -*-

import pickle

d = dict(name='ellery', age='20')
with open('dump.txt', 'wb') as f:
    pickle.dump(d, f)

with open('dump.txt', 'rb') as ff:
    d = pickle.load(ff)
print(d)