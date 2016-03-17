# -*- coding: utf-8 -*-

with open('./abc.txt', 'w') as f :
    f.write('test write.')
print('end')

with open('./abc.txt', 'a') as fa :
    fa.write('test append write.')
print('end')