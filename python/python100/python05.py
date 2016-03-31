# -*- coding: utf-8 -*-

'输入三个整数x,y,z，请把这三个数由小到大输出。'

x = int(input('x:'))
y = int(input('y:'))
z = int(input('z:'))

if x > y :
    x = x + y
    y = x - y
    x = x - y

if y > z :
    y = y + z
    z = y - z
    y = y - z

if x > z :
    x = x + z
    z = x - z
    x = x - z

print(x, y, z)