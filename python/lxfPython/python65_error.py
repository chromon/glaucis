# -*- coding: utf-8 -*-

try:
    print('try...')
    r = 10 / 0
    print('result:', r)
except ZeroDivisionError as e:
    print('except', e)
    #raise e
else :
    print('no error.')
finally:
    print('finally...')
print('end')