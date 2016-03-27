# -*- coding: utf-8 -*-

from tkinter import *
import tkinter.messagebox as messagebox

class Application(Frame) :
    def __init__(self, master=None) :
        Frame.__init__(self, master)
        self.pack()
        self.createWidgets()

    def createWidgets(self) :
        self.nameInput = Entry(self)
        self.nameInput.pack()
        self.alterButton = Button(self, text='Hello', command=self.hello)
        self.alterButton.pack()
        self.quitbtn = Button(self, text='Quit', command=self.quit)
        self.quitbtn.pack()

    def hello(self) :
        name = self.nameInput.get() or 'world'
        messagebox.showinfo('Message', 'Hello, %s' % name)

app = Application()
app.master.title('Hello, world!')
app.mainloop()