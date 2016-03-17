# -*- coding: utf-8 -*-

import logging
logging.basicConfig(level=logging.INFO)

def foo(s) :
    n = int(s) 
    logging.info('n = %d' % n)
    print(10 / n)

foo(0)