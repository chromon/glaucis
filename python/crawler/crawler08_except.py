# -*- coding: utf-8 -*-

import urllib.request

#url = 'http://127.0.0.1:5000/abc'
url = 'http://127.0.0.1:5000'

try:
    page = urllib.request.urlopen(url).read()
    print(page)
except urllib.error.URLError as e:
    if hasattr(e, 'code') :
        print('The server couldn\'t fulfill the request.')
        print('Error code:', e.code)
    elif hasattr(e, 'reason') :
        print('We fail to reach the server.')
        print('Error reason:', e.reason)
else:
    print('No exception was raised.')