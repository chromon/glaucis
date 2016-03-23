# -*- coding: utf-8 -*-

import re

m = re.match(r'^(\d{3})\-(\d{3,8})$', '123-238942')
print(m.group(0))
print(m.group(1))
print(m.group(2))

#t = '19:23:48'
t = '3:4:3'
mm = re.match(r'(0[0-9]|1[0-9]|2[0-3]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])\:(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]|[0-9])', t)
print(mm.group(0))
print(mm.group(1))
print(mm.group(2))
print(mm.group(3))