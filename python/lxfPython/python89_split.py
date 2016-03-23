# -*- coding: utf-8 -*-

import re

print(re.split(r'\s+', 'a b   c  d'))
print(re.split(r'[\s\,]+', 'a,b ,c  d'))
