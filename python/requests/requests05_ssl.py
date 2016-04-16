# -*- coding: utf-8 -*-

import requests

# requests.get('https://kennethreitz.com', verify=True)
r = requests.get('https://github.com', verify=True)
print(r.status_code)