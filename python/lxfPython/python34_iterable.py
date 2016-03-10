# -*- conding : utf-8 -*-

from collections import Iterable
from collections import Iterator

print(isinstance([], Iterable))
print(isinstance({}, Iterable))
print(isinstance('', Iterable))
print(isinstance((x for x in range(1, 10)), Iterable))
print(isinstance(100, Iterable))
print(range(10))

print(isinstance([], Iterator))
print(isinstance({}, Iterator))
print(isinstance('', Iterator))
print(isinstance((x for x in range(1, 10)), Iterator))
print(isinstance(range(10), Iterator))