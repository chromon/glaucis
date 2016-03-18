# -*- coding: utf-8 -*-

from io import StringIO

f = StringIO()
f.write('Hello')
f.write(', ')
f.write('world.')
print(f.getvalue())

fs = StringIO('Hello!\nHave a nice day!\nByeBye!')
while True:
    s = fs.readline()
    if s == '':
        break
    print(s.strip())