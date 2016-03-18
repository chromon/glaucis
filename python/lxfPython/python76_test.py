# -*- coding: utf-8 -*-

import os, datetime, time

def mydir(base_dir='.') :
    #base_dir = '.'
    current_time = time.strftime('%Y-%m-%d  %H:%M', time.localtime())
    print('%s \t <DIR> \t %s \t' % (current_time, '.'))
    print('%s \t <DIR> \t %s \t' % (current_time, '..'))
    for x in os.listdir(base_dir) :
        file_path = os.path.join(base_dir, x)
        t = getFileTime(file_path)
        size = os.path.getsize(file_path)
        if os.path.isdir(x) :
            print('%s \t <DIR> \t\t %s' % (t, x))
        elif os.path.isfile(x) :
            print('%s \t  \t %s \t %s' % (t, size, x))

def getFileTime(file_path) :
    t = os.path.getmtime(file_path)
    dt = datetime.datetime.fromtimestamp(t)
    return dt.strftime('%Y-%m-%d  %H:%M')

mydir()