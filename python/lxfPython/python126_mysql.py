 # -*- coding: utf-8 -*-

import pymysql

conn = pymysql.connect(user='root', passwd='root', db='test')   
cursor = conn.cursor()
cursor.execute('create table user(id varchar(20) primary key, name varchar(20))')
cursor.execute('insert into user values(\'1\', \'ellery\')')
print(cursor.rowcount)
conn.commit()
cursor.close()

cursor = conn.cursor()
cursor.execute('select * from user')
values = cursor.fetchall()
print(values)

cursor.close()
conn.close()