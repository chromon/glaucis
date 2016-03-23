# -*- coding: utf-8 -*-

import re

email = re.compile(r'^\w[\w\.\d]{0,14}\@[\w\d]{3,10}\.[\w]{3,4}$')
email2 = re.compile(r'^[A-Za-z]+[.]?[A-Za-z0-9]*\@[A-Za-z0-9]+\.[A-Za-z0-9]{2,4}$')
email3 = re.compile(r'^\<[A-Za-z]+\s[A-Za-z]+\>\s+[A-Za-z]+[.]?[A-Za-z0-9]*\@[A-Za-z0-9]+\.[A-Za-z0-9]{2,4}$')
#str = 'alotry@gmail.com'
#str = 'bill.gates@gmail.com'
str = '<bill gates> bill.gates@gmail.com'
if email3.match(str) :
    print('ok')
else :
    print('failed')