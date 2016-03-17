# -*- coding: utf-8 -*-

#f= open('./abc.txt', 'r')
#print(f.read())

try:
    f = open('./abc.txt', 'r')
    print(f.read())
finally:
    if f :
        f.close()
print('end')

with open('./abc.txt', 'r') as fo:
    print(fo.read())
print('end')

with open('./abc.txt', 'r') as foo:
    for i in foo.readlines() :
        print(i.strip())
print('end')

with open('./image.jpg', 'rb') as frb:
    # a little big~
    # print(frb.read())