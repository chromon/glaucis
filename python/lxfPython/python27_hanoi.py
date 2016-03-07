# -*- coding: utf-8 -*-

def move(n, a, b, c) :
	if n == 1:
		print(a, '-->', c)
	else :
		move(n-1, a, c, b) 	# 前n-1 个盘子从 a 移动到 b
		move(1, a, b, c)	# 第 n 个盘子从 a 移动到 c
		move(n-1, b, a, c)	# 再将剩余 n-1 个盘子从 b 移动到 c

move(3, 'A', 'B', 'C')