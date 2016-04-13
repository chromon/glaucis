# -*- coding: utf-8 -*-

import urllib.request
import urllib.parse
import http.cookiejar

url = 'http://www.zhihu.com/'
filename = 'zhcookie.txt'

header = {
        'User-Agent': "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:34.0) Gecko/20100101 Firefox/34.0",
        'Host': "www.zhihu.com",
        'Referer': "http://www.zhihu.com/",
        'X-Requested-With': "XMLHttpRequest"
    }

try:
    cookie = http.cookiejar.MozillaCookieJar(filename)
    handler = urllib.request.HTTPCookieProcessor(cookie)
    opener = urllib.request.build_opener(handler)
    values = {'account':'allotory@msn.com', 'password': 'zhseverus1258740'}
    postdata = urllib.parse.urlencode(values)
    response = opener.open(url)
    cookie.save(ignore_discard=True, ignore_expires=True)

    url2 = 'http://www.zhihu.com/topic'
    result = opener.open(url2)
    print(result.read().decode())
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