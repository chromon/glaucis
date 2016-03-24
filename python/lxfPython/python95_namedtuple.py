# -*- coding: utf-8 -*-

from collections import namedtuple

Point = namedtuple('point', ['x', 'y'])
p = Point(1, 2)
print(p.x)
print(p.y)

Circle = namedtupel('circle', ['x', 'y', 'r'])
c = Circle()