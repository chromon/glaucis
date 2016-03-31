# -*- coding: utf-8 -*-

'将一个列表的数据复制到另一个列表中。'

l = [1, 2, 3, 4, 5]
#a = l
a = l[:]

print(a)
print(l)
a.append(8)
print(a)
print(l)