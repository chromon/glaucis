# -*- coding : utf-8 -*-

def fn(self, name):
    print('hello, %s' % name)

Hello = type('Hello', (object,), dict(sayhi=fn))
h = Hello()
h.sayhi('world.')