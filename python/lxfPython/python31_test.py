# -*- coding: utf-8 -*-

l = ['Hello', 'World', 18, 'Hello', 'Python']
l2 = list(s.lower() for s in l if isinstance(s, str))
print(l2)