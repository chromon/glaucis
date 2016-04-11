# -*- coding: utf-8 -*-

import urllib.request

url = 'http://127.0.0.1:5000/abc'

try :
    page = urllib.request.urlopen(url).read()
    print(page)
except urllib.error.HTTPError as e :
    print(e.code)
finally :
    print('End.')
