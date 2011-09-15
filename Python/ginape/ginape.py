#!/usr/bin/python
# -*- coding: utf-8 -*-

'''
    ginape. A simple wx Python gedit clone. <http://www.giovannicapuano.net>
    Copyright (C) 2011  Giovanni 'Roxas Shadow' Capuano

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
'''

import wx, os
class ginape(wx.Frame):
	def __init__(self, parent, id, title):
		wx.Frame.__init__(self, parent, id, title) # Not resizable with this style
		self.panel = wx.Panel(self)
		self.themeChosen = 'default'
		self.filename = ''
		self.dirname = ''
		
		# Menu
		self.CreateStatusBar()
		self.SetStatusText('Welcome in ginape, I\'m ready to work :)')
		
		# Menu file
		self.file = wx.Menu()
		self.new = self.file.Append(wx.ID_NEW, '&New', 'Create a file.')
		self.open = self.file.Append(wx.ID_OPEN, '&Open', 'Open a file.')
		self.file.AppendSeparator()
		self.save = self.file.Append(wx.ID_SAVE, 'Sav&e', 'Save the file.')
		self.saveas = self.file.Append(wx.ID_SAVEAS, 'Sav&e as...', 'Save the file as new.')
		self.file.AppendSeparator()
		self.discard = self.file.Append(wx.ID_REVERT_TO_SAVED, '&Discard', 'Go to original text.')
		self.close = self.file.Append(wx.ID_CLOSE, '&Close', 'Close the file.')
		self.file.AppendSeparator()
		self.exit = self.file.Append(wx.ID_EXIT, 'E&xit', 'Close the program.')
		
		# Menu view
		self.view = wx.Menu()
		self.undo = self.view.Append(wx.ID_UNDO, '&Undo', 'Go to last operation.')
		self.redo = self.view.Append(wx.ID_REDO, '&Redo', 'Go to next operation.')
		self.view.AppendSeparator()
		self.cut = self.view.Append(wx.ID_CUT, '&Cut', 'Cut the selected text.')
		self.copy = self.view.Append(wx.ID_COPY, '&Copy', 'Copy the selected text.')
		self.paste = self.view.Append(wx.ID_PASTE, '&Paste', 'Paste the selected text.')
		self.view.AppendSeparator()
		self.selectall = self.view.Append(wx.ID_SELECTALL, '&Select all', 'Select all the text.')
		self.clear = self.view.Append(wx.ID_CLEAR, '&Clear', 'Clear the text.')
		self.view.AppendSeparator()
		self.upper = self.view.Append(wx.ID_ANY, '&Upper case', 'Upper case the text.')
		self.lower = self.view.Append(wx.ID_ANY, '&Lower case', 'Lower case the text.')
		self.view.AppendSeparator()
		self.theme = self.view.Append(wx.ID_PROPERTIES, '&Theme', 'Change the theme.')
		
		# Menu search
		self.searchMenu = wx.Menu()
		self.search = self.searchMenu.Append(wx.ID_FIND, '&Search', 'Search one or more words in the text.')
		
		# Menu about
		self.helpMenu = wx.Menu()
		self.about = self.helpMenu.Append(wx.ID_ABOUT, '&About', 'About ginape...')
		
		# Menu bar
		self.menubar = wx.MenuBar()
		self.menubar.Append(self.file, '&File')
		self.menubar.Append(self.view, '&View')
		self.menubar.Append(self.searchMenu, '&Search')
		self.menubar.Append(self.helpMenu, '&Help')
		self.SetMenuBar(self.menubar)
		
		# Textarea
		self.text = wx.TextCtrl(self.panel, style=wx.TE_MULTILINE|wx.TE_BESTWRAP|wx.TE_AUTO_URL|wx.TE_NOHIDESEL)
		self.panel.DragAcceptFiles = True
		self.text.SetFocus()
		self.bsizer = wx.BoxSizer()
		self.bsizer.Add(self.text, proportion=1, flag=wx.EXPAND)
		self.vbox = wx.BoxSizer(wx.VERTICAL)
		self.vbox.Add(self.bsizer, proportion=1, flag=wx.EXPAND|wx.ALL, border=6)
		self.panel.SetSizer(self.vbox)
		
		# Events
		self.Bind(wx.EVT_TEXT, self.onThemeChange, self.text)
		self.Bind(wx.EVT_DROP_FILES, self.onDrag, self.text) # It works only on Windows :(
		self.Bind(wx.EVT_MENU, self.onNew, self.new)
		self.Bind(wx.EVT_MENU, self.onOpen, self.open)
		self.Bind(wx.EVT_MENU, self.onSave, self.save)
		self.Bind(wx.EVT_MENU, self.onSaveAs, self.saveas)
		self.Bind(wx.EVT_MENU, self.onClose, self.close)
		self.Bind(wx.EVT_MENU, self.onAbout, self.about)
		self.Bind(wx.EVT_MENU, self.onExit, self.exit)
		self.Bind(wx.EVT_MENU, self.setTheme, self.theme)
		self.Bind(wx.EVT_MENU, self.onCopy, self.copy)
		self.Bind(wx.EVT_MENU, self.onCut, self.cut)
		self.Bind(wx.EVT_MENU, self.onPaste, self.paste)
		self.Bind(wx.EVT_MENU, self.onClear, self.clear)
		self.Bind(wx.EVT_MENU, self.onUpperCase, self.upper)
		self.Bind(wx.EVT_MENU, self.onLowerCase, self.lower)
		self.Bind(wx.EVT_MENU, self.onUndo, self.undo)
		self.Bind(wx.EVT_MENU, self.onRedo, self.redo)
		self.Bind(wx.EVT_MENU, self.onDiscard, self.discard)
		self.Bind(wx.EVT_MENU, self.onSelectAll, self.selectall)
		self.Bind(wx.EVT_MENU, self.onSearch, self.search)
		
		self.Centre()
		self.Show()
			
	def getNumberOfChars(self):
		count = 0
		string = self.text.GetValue()
		for c in string:
			if c != '':
				count += 1
		return count
		
	def onDrag(self, event):
		if self.text.OnDropFiles != '':
			self.text.LoadFile(self.text.OnDropFiles)
		self.SetStatusText('File dragged.')
	
	def onNew(self, event):
		self.filename = ''
		self.dirname = ''
		self.onClear(self)
		
	def onOpen(self, event):
		self.filename = ''
		self.dirname = ''
		dialog = wx.FileDialog(self, 'Choose a file', self.dirname, '', '*', wx.OPEN)
		if dialog.ShowModal() == wx.ID_OK:
			self.filename = dialog.GetFilename()
			self.dirname = dialog.GetDirectory()
		if self.filename != '' and self.dirname != '':
			self.text.LoadFile(os.path.join(self.dirname, self.filename))
			dialog.Destroy() # Destroy a wx object
			self.SetStatusText(self.filename+' opened.')
		
	def onSave(self, event):
		if self.filename == '' or self.dirname == '':
			self.filename = ''
			self.dirname = ''
			dialog = wx.FileDialog(self, 'Choose a file', self.dirname, '', '*', wx.SAVE)
			if dialog.ShowModal() == wx.ID_OK:
				self.filename = dialog.GetFilename()
				self.dirname = dialog.GetDirectory()
				
		if self.filename != '' and self.dirname != '':
			try:
				self.SetStatusText('Saving '+self.filename+'...')
				self.text.SaveFile(os.path.join(self.dirname, self.filename))
				self.SetStatusText(self.filename+' saved.')
			except:
				self.SetStatusText('An error was occurred when saving '+self.filename+'.')
		
	def onSaveAs(self, event):
		self.filename = ''
		self.dirname = ''
		dialog = wx.FileDialog(self, 'Choose a file', self.dirname, '', '*', wx.SAVE)
		if dialog.ShowModal() == wx.ID_OK:
			self.filename = dialog.GetFilename()
			self.dirname = dialog.GetDirectory()
				
		if self.filename != '' and self.dirname != '':
			try:
				self.SetStatusText('Saving '+self.filename+'...')
				self.text.SaveFile(os.path.join(self.dirname, self.filename))
				self.SetStatusText(self.filename+' saved.')
			except:
				self.SetStatusText('An error was occurred when saving '+self.filename+'.')
			
	def onClose(self, event):
		if self.filename != '' and self.dirname != '':
			self.SetStatusText(self.filename+' closed.')
			self.filename = ''
			self.dirname = ''
		self.onClear(self)
		
	def onAbout(self, event):
		wx.MessageBox('ginape\n(C) 2011 Giovanni Capuano\nGNU is now a Python editor, and you have to calls with the Italian phonetic.\n`g` as `jo` of `John`\n`i` as `i` of `Italy`\n`nape` easly as you pronunce it in English :-)', 'About')
		
	def onExit(self, event):
		self.SetStatusText('Bye :)')
		self.Close(True)
	
	def setTheme(self, event):
		self.themeChosen = 'oblivion'
		self.onThemeChange(self)
		 
	def onThemeChange(self, event):
		if self.themeChosen == 'oblivion':
			self.panel.SetBackgroundColour('#ecebea') # In the truth, this is the default GTK background color...
			self.text.SetBackgroundColour('#2e3436')
			actualPoint = self.text.GetInsertionPoint() # Registers the actual char pointer 
			self.text.SetInsertionPoint(0) # Go to first char
			self.text.SetStyle(0, self.getNumberOfChars(), wx.TextAttr('white', wx.NullColour)) # Style to 0-LastChar
			self.text.SetInsertionPoint(actualPoint) # Return to char registered first
	
	def onCopy(self, event):
		if self.text.CanCopy:
			self.SetStatusText('Copied.')
			self.text.Copy()
		else:
			self.SetStatusText('Nothing to copy.')
	
	def onCut(self, event):
		if self.text.CanCut:
			self.SetStatusText('Cutted.')
			self.text.Cut()
		else:
			self.SetStatusText('Nothing to cut.')
	
	def onPaste(self, event):
		if self.text.CanPaste:
			self.SetStatusText('Pasted.')
			self.text.Paste()
		else:
			self.SetStatusText('Nothing to paste.')
	
	def onClear(self, event):
		self.text.Clear()
		
	def onUpperCase(self, event):
		self.text.SetValue(self.text.GetValue().upper())
		self.SetStatusText('Text upper cased.')
		
	def onLowerCase(self, event):
		self.text.SetValue(self.text.GetValue().lower())
		self.SetStatusText('Text lower cased.')
		
	def onUndo(self, event):
		if self.text.CanUndo:
			self.SetStatusText('Undoed.')
			self.text.Undo()
		else:
			self.SetStatusText('Nothing to undo.')
	
	def onRedo(self, event):
		if self.text.CanRedo:
			self.SetStatusText('Redoed.')
			self.text.Redo()
		else:
			self.SetStatusText('Nothing to redo.')
		
	def onDiscard(self, event):
		self.text.DiscardEdits()
		
	def onSelectAll(self, event):
		self.text.SelectAll()
		
	def onSearch(self, event):
		self.text.SetSelection(1,3)
		
app = wx.App()
ginape(None, -1, 'ginape')
app.MainLoop()
