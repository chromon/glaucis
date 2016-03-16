# -*- coding: utf-8 -*-

from enum import Enum, unique 

month = Enum('month', ('jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'aug', 'sep', 'oct', 'nov', 'dec'))

for name, member in month.__members__.items() :
    print(name, '-->', member, member.value)

@unique
class Weekday(Enum) :
    sun = 0
    mon = 1
    tue = 2
    wed = 3
    thu = 4
    fri = 5
    sat = 6

print(Weekday.wed)
print(Weekday['wed'])
print(Weekday.wed.value)