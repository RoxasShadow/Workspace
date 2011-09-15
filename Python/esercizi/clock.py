#!/usr/bin/python
# -*- coding: utf-8 -*-

import wx
import wx.gizmos as gizmos
import time

class Clock(wx.Frame):
	def __init__(self, parent, id, title):
		wx.Frame.__init__(self, parent, id, title, size=(220, 80))
		self.time = False
		
		# Led
		self.led = gizmos.LEDNumberCtrl(self, -1, (0,2), (220, 50))
		self.led.SetValue(' 000000 ')
		
		# Timer
		self.timer = wx.Timer(self)
		self.timer.Start(1000)

		# Buttons
		self.button = wx.Button(self, 1, 'Date', (70, 52))
		
		# Events
		self.Bind(wx.EVT_BUTTON, self.changeMode, id=1)
		self.Bind(wx.EVT_TIMER, self.update)

		self.Centre()
		self.Show()
		
	def update(self, event):
		if(self.time == False):
			self.led.SetValue(time.strftime('%H %M %S', time.localtime(time.time())))
		else:
			self.led.SetValue(time.strftime('%d %m %y', time.localtime(time.time())))
		
	def changeMode(self, event):
		if(self.time == False):
			self.time = True
			self.button.SetLabel('Time')
		else:
			self.time = False
			self.button.SetLabel('Date')
		self.update
		
app = wx.App()
Clock(None, -1, 'Clock')
app.MainLoop()
