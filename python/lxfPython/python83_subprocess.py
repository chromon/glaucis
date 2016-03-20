# -*- coding: utf-8 -*-

import subprocess

print('$ nslookup www.baidu.com')
r = subprocess.call(['nslookup', 'www.baidu.com'])
print('exit code:', r)