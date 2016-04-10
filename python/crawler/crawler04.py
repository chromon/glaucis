# -*- coding: utf-8 -*-

import urllib.request
import urllib.parse

url = 'http://127.0.0.1:5000/signin_get'

values = {'username': 'ellery', 'password': 'admin'}

get_url = urllib.parse.urlencode(values).encode()
print(get_url)

full_url = url + '?' + get_url
page = urllib.request.urlopen(full_url).read()
print(page)