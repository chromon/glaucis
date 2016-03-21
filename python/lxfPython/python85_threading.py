# -*- coding: utf-8 -*-

import time, threading

def loop() :
    print('thread %s running...' % threading.current_thread().name)
    n = 0
    while n < 5 :
        n = n + 1
        print('thread %s >>> %s' %(threading.current_thread().name, n))
        time.sleep(1)
    print('thread %s end.' % threading.current_thread().name)

print('thread %s running.' % threading.current_thread().name)
t = threading.Thread(target=loop, name='loopthread')
t.start()
t.join()
print('thread %s end.' % threading.current_thread().name)