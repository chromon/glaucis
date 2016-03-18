# -*- coding: utf-8 -*-

import os

def dirfilter(base_dir) :
    print(os.listdir(base_dir))
    for x in os.listdir(base_dir) :
        if os.path.isfile(x) :
            print(x)
        elif os.path.isdir(x) :
            print('base_dir:', base_dir)
            b = os.path.join(base_dir, x)
            print(b)
            dirfilter(b)

dirfilter('.')