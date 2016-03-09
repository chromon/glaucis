# -*- coding: utf-8 -*-
from collections import Iterable

d = {'java': 1, 'php': 33, 'python': 28, 'javascript': 98}

for key in d:
	print(key)

for value in d.values():
	print(value)

for k, v in d.items():
	print(k, '==>', v)

print(isinstance('ABC', Iterable))

for i, value in enumerate(['java', 'php', 'c']):
	print(i, '-->', value)