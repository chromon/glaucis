# -*- coding: utf-8 -*-

import os, shutil

print(os.name)
#print(os.uname)
print(os.environ)
print(os.environ.get('PATH'))
print(os.path.abspath('.'))

print(os.path.join('.', 'testdir'))
#os.mkdir(os.path.join('.', 'testdir'))

print(os.path.split(os.path.abspath('.')))
print(os.path.splitext('aaa/bbb/c.txt'))

#os.rename('rename.txt', 'rename2.txt')
#os.remove('rename2.txt')

#shutil.copyfile('./abc.txt', './a.txt')

print(list(x for x in os.listdir('.') if os.path.isdir(x)))
print(list(x for x in os.listdir('.') if os.path.isfile(x) and os.path.splitext(x)[1] == '.py'))