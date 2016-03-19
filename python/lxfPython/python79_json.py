# -*- coding: utf-8 -*-

import json

d = dict(name='ellery', age=20)
print(json.dumps(d))

json_str = '{"age": 20, "name": "ellery"}'
print(json.loads(json_str))