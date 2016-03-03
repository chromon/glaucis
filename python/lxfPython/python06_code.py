# -*- coding: utf-8 -*-

print('这是一个带中文的String.')
print(ord('A'))
print(ord('a'))
print(chr(20013))
print(chr(65))

print('ABC'.encode('ascii'))
print('中文'.encode('utf-8'))
print(b'\xe4\xb8\xad\xe6\x96\x87'.decode('utf-8'))

print(len('ABC')
print(len('中文'.encode('utf-8')))
print(len(b'\xe4\xb8\xad\xe6\x96\x87'))