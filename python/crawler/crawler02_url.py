# -*- coding: utf-8 -*-

import urllib.request

info = {}
info['word'] = 'ellery'

url_values = urllib.parse.urlencode(info)
url = 'http://www.baidu.com/s?'
full_url = url + url_values

data = urllib.request.urlopen(full_url).read()
#data = data.decode('utf-8')
print(data)