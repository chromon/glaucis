# -*- coding: utf-8 -*-

import urllib.request

url = 'http://127.0.0.1:5000'

try :
    page = urllib.request.urlopen(url).read()
    print(page)
except urllib.error.URLError as e :
    print(e.reason)
finally :
    print('End.')
