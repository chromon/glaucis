# -*- coding: utf-8 -*-

import urllib.request

url = 'http://rrurl.cn/b1UZuP'

try:
    req = urllib.request.Request(url)
    response = urllib.request.urlopen(req)

    print('url:', url)
    print('real url:', response.geturl())

    #page = response.read()
    #print(page)
except urllib.error.URLError as e:
    if hasattr(e, 'code') :
        print('The server couldn\'t fulfill the request.')
        print('Error code:', e.code)
    elif hasattr(e, 'reason') :
        print('We fail to reach the server.')
        print('Error reason:', e.reason)
else:
    print('No exception was raised.')