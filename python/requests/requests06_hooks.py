# -*- coding: utf-8 -*-

import requests

def print_url(r) :
    print(r.geturl)

hooks = dict(response=print_url)

r = requests.get('http://httpbin.org', hooks=dict(response=print_url))
print(r.status_code)