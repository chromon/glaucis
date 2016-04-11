# -*- coding: utf-8 -*-

import urllib.request
import urllib.parse

url = 'http://127.0.0.1:5000/signin'

values = {'username': 'ellery', 'password': 'admin'}

data = urllib.parse.urlencode(values).encode()
page = urllib.request.urlopen(url, data).read()
print(page)