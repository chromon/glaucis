# -*- coding: utf-8 -*-

d = {'java': 3, 'php': 23, 'c': 18, 'python': 8}
print(d['java'])
if 'c++' in d:
	print(d['c++'])
else:
	print('not exists~')
	d['c++'] = 99
print(d)
d.pop('c++')
print(d)
