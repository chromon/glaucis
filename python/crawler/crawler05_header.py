# -*- coding: utf-8 -*-

import urllib.request

# User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) 
# User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)

user_agent = 'Mozilla/5.0 (Windows NT 6.1; Win64; x64)'
headers = {'User-Agent': user_agent}

url = 'http://127.0.0.1:5000/signin'

values = {'username': 'ellery', 'password': 'admin'}

data = urllib.parse.urlencode(values).encode()

req = urllib.request.Request(url, data, headers)
response = urllib.request.urlopen(req)
page = response.read()
print(page)