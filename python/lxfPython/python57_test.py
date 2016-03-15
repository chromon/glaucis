# -*- coding: utf-8 -*-

class Screen(object) :
    @property
    def width(self):
        return self._width

    @width.setter
    def width(self, width) :
        self._width = width

    @property
    def height(self):
        return self._height
    
    @height.setter
    def height(self, height) :
        self._height = height

    @property
    def resolution(self):
        return self._height * self._width

s = Screen()
s.width = 1024
s.height = 768
print(s.resolution)
assert s.resolution == 786432, '1024 * 768 = %d ?' % s.resolution
