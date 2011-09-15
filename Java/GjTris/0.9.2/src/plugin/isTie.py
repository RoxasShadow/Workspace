'''
	/plugin/isresponse.py
	(C) Giovanni Capuano 2011
'''

### A GjTris plugin wich checks if there is a response. ###
response = "true"
for i in buttons:
	if i == "":
		response = "false"
