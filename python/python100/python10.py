# -*- coding: utf-8 -*-

'题目：暂停一秒输出。'

import time

for i in range(10) :
    print(time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))

    # 暂停一秒
    time.sleep(1)