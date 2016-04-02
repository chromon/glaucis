# -*- coding: utf-8 -*-

'题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。'

str = 'hello, 1234, #%*'

letters = 0
numbers = 0
spaces = 0
others = 0

for c in str :
    if c.isalpha() :
        letters += 1
    elif c.isdigit() :
        numbers += 1
    elif c.isspace() :
        spaces += 1
    else :
        others += 1

print('letters: %s' % letters)
print('numbers: %s' % numbers)
print('spaces: %s' % spaces)
print('others: %s' % others)