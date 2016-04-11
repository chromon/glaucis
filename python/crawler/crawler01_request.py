# -*- coding: utf-8 -*-

import urllib.request

url = 'http://www.baidu.com'
#data = urllib.request.urlopen(url).read()
#data = data.decode('utf-8')
#print(data)

req = urllib.request.Request(url)
response = urllib.request.urlopen(req)
data2 = response.read()
print(data2)
