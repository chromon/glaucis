# -*- coding: utf-8 -*-

from collections import deque

q = deque(['x', 'y', 'z'])
q.append('a')
q.appendleft('b')
print(q)