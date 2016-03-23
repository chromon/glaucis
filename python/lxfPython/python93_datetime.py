# -*- coding: utf-8 -*-

from datetime import datetime, timedelta, timezone

now = datetime.now()
print(now)

d = datetime(2016, 3, 17, 11, 22, 33)
print(d)
print(d.timestamp())

ts = 1458184953.0
print(datetime.fromtimestamp(ts))
print(datetime.utcfromtimestamp(ts))

str = '2016-03-22 12:23:34'
da = datetime.strptime(str, '%Y-%m-%d %H:%M:%S')
print(da)

print(now.strftime('%a %b %d %H:%M'))
print('--------------')

print(now)
print(now + timedelta(hours=10))
print(now - timedelta(days=1))
print(now + timedelta(days=2, hours=3))
print(now + timedelta(days=2, hours=3, minutes=20))
print(now + timedelta(days=2, hours=3, minutes=20, seconds=3))
print('--------------')

tz_3 = timezone(timedelta(hours=8))
no = datetime.now()
print(no)
dt = now.replace(tzinfo=tz_3)
print(dt)
print('--------------')

utc0 = datetime.utcnow().replace(tzinfo=timezone.utc)
print(utc0)
print(utc0.astimezone(timezone(timedelta(hours=8))))