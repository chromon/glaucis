# -*- coding: utf-8 -*-

def is_palindrome(n) :
	if n > 10:
		return str(n) == str(n)[::-1]
output = filter(is_palindrome,range(1,1000))
print(list(output))