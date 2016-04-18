# -*- coding: utf-8 -*-

import requests
from requests.auth import HTTPBasicAuth
from requests.auth import HTTPDigestAuth

# r = requests.get('https://api.github.com/user', auth=HTTPBasicAuth('allotory', 'xxxxxx'))
r = requests.get('http://httpbin.org/digest-auth/auth/user/pass', auth=HTTPDigestAuth('user', 'pass'))
print(r)
