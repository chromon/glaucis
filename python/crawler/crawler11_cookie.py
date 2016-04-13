# -*- coding: utf-8 -*-

import urllib.request
import http.cookiejar

url = 'http://www.baidu.com'

try:
    cookie = http.cookiejar.CookieJar()
    handler = urllib.request.HTTPCookieProcessor(cookie)
    opener = urllib.request.build_opener(handler)
    response = opener.open(url)
    for item in cookie:
        print('name:', item.name)
        print('value:', item.value)
except urllib.error.URLError as e:
    if hasattr(e, 'code') :
        print('The server couldn\'t fulfill the request.')
        print('Error code:', e.code)
    elif hasattr(e, 'reason') :
        print('We fail to reach the server.')
        print('Error reason:', e.reason)
else:
    print('------------------------')
    print('No exception was raised.')