# -*- coding: utf-8 -*-

import requests

r = requests.get('http://en.wikipedia.org/wiki/Monty_Python')

# 返回的响应头
print(r.headers)

# 发送的请求头
print(r.request.headers)