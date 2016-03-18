# -*- coding: utf-8 -*-

from io import BytesIO

b = BytesIO()
b.write('中文'.encode('utf-8'))
print(b.getvalue())