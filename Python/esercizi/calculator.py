#!/usr/bin/python

# interactivebutton.py

import wx
from wx.lib.buttons import GenButton

class Editor(wx.Frame):
	def __init__(self, parent, id, title):
		wx.Frame.__init__(self, parent, id, title, size=(400, 350))
		
		# Text
		wx.StaticText(self, -1, 'X', (10, 20))
		wx.StaticText(self, -1, 'Y', (10, 60))

		# Inputbox
		self.x = wx.TextCtrl(self, -1, '',  (110, 15), (120, -1))
		self.y = wx.TextCtrl(self, -1, '',  (110, 55), (120, -1))

		# Buttons
		self.sumbtn = wx.Button(self, 1, 'Sum', (10, 160))
		self.moltbtn = wx.Button(self, 2, 'Moltiplication', (100, 160))
		self.moltbtn = wx.Button(self, 3, 'Division', (200, 160))
		self.moltbtn = wx.Button(self, 4, 'Substraction', (290, 160))
		
		# Event buttons
		self.Bind(wx.EVT_BUTTON, self.sum, id=1)
		self.Bind(wx.EVT_BUTTON, self.mol, id=2)
		self.Bind(wx.EVT_BUTTON, self.div, id=3)
		self.Bind(wx.EVT_BUTTON, self.sub, id=4)

		self.Centre()
		self.Show()
		
	def sum(self, event):
		print (int(self.x.GetValue()) +  int(self.y.GetValue()))
		
	def mol(self, event):
		print (int(self.x.GetValue()) *  int(self.y.GetValue()))
		
	def div(self, event):
		if int(self.y.GetValue()) == 0:
			print 'Division per zero denied.'
		elif int(self.x.GetValue()) == int(self.y.GetValue()):
			print 1
		elif int(self.x.GetValue()) > int(self.y.GetValue()):
			print (int(self.x.GetValue()) /  int(self.y.GetValue()))
		
	def sub(self, event):
		print (int(self.x.GetValue()) -  int(self.y.GetValue()))
		
app = wx.App()
Editor(None, -1, 'Calculator')
app.MainLoop()
