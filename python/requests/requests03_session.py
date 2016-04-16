# -*- coding: utf-8 -*-

import requests

# 不使用session则cookie不能保存
# requests.get('http://httpbin.org/cookies/set/sessioncookie/123456789')
# r = requests.get('http://httpbin.org/cookies')
# print(r.text)

# 使用session
# s = requests.Session()
# s.get('http://httpbin.org/cookies/set/sessioncookies/hahahahahaha')
# r = s.get('http://httpbin.org/cookies')
# print(r.text)

# 设置缺省值
s = requests.Session()
s.headers.update({'default-headers': 'hahahahat'})
# r = s.get('http://httpbin.org/headers', headers={'default-headers2': '123456'})
r = s.get('http://httpbin.org/headers', headers={'default-headers': '123456'})
print(r.text)