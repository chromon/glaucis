# -*- coding: utf-8 -*-

'题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？'

def rabbit(n) :
    if n == 1 :
        return 1
    elif n == 2 :
        return 1
    else :
        return rabbit(n - 1) + rabbit(n - 2)

for i in range(1, 10) :
    print('第 %s 个月有 %s 对兔子。' % (i, rabbit(i)))