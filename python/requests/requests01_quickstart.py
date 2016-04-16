# -*- coding: utf-8 -*-

import requests
import json

# params：查询字符串 data：表单数据
payload = {'k1': 'v1'}

headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64)'}

files = {'file': open('abc.txt', 'rb')}

# r = requests.get('http://httpbin.org/get', params=payload)
# 其他请求
# r = requests.post('http://httpbin.org/post', json.dumps(payload) headers=headers)
r = requests.post('http://httpbin.org/post', files=files)
# r = requests.put('http://httpbin.org/put')
# r = requests.delete('http://httpbin.org/delete')
# r = requests.head('http://httpbin.org/get')
# r = requests.options('http://httpbin.org/get')

# 重定向
# r = requests.get('http://github.com', allow_redirects=True)

# 基础操作
print('type(r):', type(r))
print('r:', r)
print('r.status_code:', r.status_code)
print('r.encoding:', r.encoding)
print('r.headers:', r.headers)
print('r.cookies', r.cookies)

# 参数
print('r.url:', r.url)

# 返回响应内容
print('r.text:', r.text)

# 请求返回二进制
print('r.content:', r.content)

# Json响应
print('r.json', r.json)

print('json.dumps(payload):', json.dumps(payload))