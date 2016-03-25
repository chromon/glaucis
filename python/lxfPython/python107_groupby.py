# -*- coding: utf-8 -*-

import itertools

for key, group in itertools.groupby('aaabbccccccddeffff') :
    print(key, list(group))