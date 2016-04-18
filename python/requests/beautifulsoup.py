# -*- coding: utf-8 -*-

from bs4 import BeautifulSoup, element

html = '''
<html><head><title>The Dormouse's story</title></head>
<body>
<p class="title" name="dromouse"><b>The Dormouse's story</b></p>
<p class="story">Once upon a time there were three little sisters; and their names were
<a href="http://example.com/elsie" class="sister" id="link1"><!-- Elsie --></a>,
<a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and
<a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>;
and they lived at the bottom of a well.</p>
<p class="story">...</p>
</body></html>
'''

soup = BeautifulSoup(html, 'html.parser')

# Tag
# basic
print(soup.title)
print(soup.prettify)
print(soup.a)
print('----------------')

# name 标签名
print(soup.name)
print(soup.head.name)
# attrs 属性
print(soup.p.attrs)
print(soup.p.attrs['class'])
print(soup.p.attrs.get('class'))
print('----------------')

# modify 修改属性
soup.p.attrs['class'] = 'newtitle'
print(soup.p.attrs['class'])
print('----------------')

# delete 删除属性
del soup.p['class']
print(soup.p)
print('----------------')

# Navigabel
# string 标签内文字
print(soup.p.string)
print('----------------')

# BeautifulSoup 类型、属性
print(soup.name)
print(soup.attrs)
print('----------------')

# Comment 去掉注释标签内文字
print(soup.a.string)
# if type(soup.a.string) == bs4.element.Comment :
#     print(soup.a.string)
print('----------------')

# contents 当前tag的直接子节点，返回list
print(soup.head.contents)
print(soup.p.contents)
print(soup.p.contents[0])
print('----------------')

# children 直接子节点，返回可迭代对象
for child in soup.body.children:
    print(child)
print('----------------')

# descendants 当前tag 全部子孙节点
for descend in soup.descendants:
    print(descend)
print('----------------')

# strings 获取全部节点内容
for string in soup.strings:
    print(repr(string))
print('----------------')
# stripped_strings 获取全部节点内容，去掉多余空白字符
for string in soup.stripped_strings:
    print(repr(string))
print('----------------')

# parent 父节点
p = soup.p
print(p.parent.name)
print('----------------')

# parents 全部父节点
content = soup.head.title.string
for parent in content.parents:
    print(parent.name)
print('----------------')

# .next_sibling  .previous_sibling 兄弟节点 空白或换行也被认为是节点
print(soup.p.next_sibling)
print(soup.p.prev_sibling)
print('----------------')


