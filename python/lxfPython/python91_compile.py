# -*- coding: utf-8 -*-

import re

regex = re.compile(r'^(\d{3,4})\-(\d{3,8})$')
m = regex.match('123-38473').groups()
print(m)