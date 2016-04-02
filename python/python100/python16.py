# -*- coding: utf-8 -*-

'题目：输出指定格式的日期。'

from datetime import datetime

str = '2015-6-1 18:19:59'

cday = datetime.strptime('2015-6-1 18:19:59', '%Y-%m-%d %H:%M:%S')

print(cday)
