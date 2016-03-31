# -*- coding: utf-8 -*-

'题目：输入某年某月某日，判断这一天是这一年的第几天？'

days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

year = int(input('year:'))
month = int(input('month:'))
day = int(input('day:'))

sum = 0

if month > 0 and month <= 12 :
    for i in days[:(month-1)] :
        sum += i

sum += day

if (year % 400 == 0) or ((year % 4 == 0) and (year % 100 != 0)) :
     sum += 1

print(sum)