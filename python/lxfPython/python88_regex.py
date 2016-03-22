# -*- coding: utf-8 -*-

import re

str = r'^\d{4}\-\d{3,8}$'
if re.match(str, '0100-238478') :
    print('ok')
else :
    print('failed')

str = r'[0-9a-zA-Z\_]+'
if re.match(str, 'a') :
    print('ok')
else :
    print('failed')