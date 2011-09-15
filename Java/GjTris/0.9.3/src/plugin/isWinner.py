'''
	/plugin/isWinner.py
	(C) Giovanni Capuano 2011
'''

### A GjTris plugin wich checks if the player or the opponent is the winner. ###
response = "false"
# Orizzontale
if button0 == mark and button1 == mark and button2 == mark:
	response = "true"
elif button3 == mark and button4 == mark and button5 == mark:
	response = "true"
elif button6 == mark and button7 == mark and button8 == mark:
	response = "true"
# Verticale
elif button0 == mark and button3 == mark and button6 == mark:
	response = "true"
elif button1 == mark and button4 == mark and button7 == mark:
	response = "true"
elif button2 == mark and button5 == mark and button8 == mark:
	response = "true"
# Diagonale
elif button0 == mark and button4 == mark and button8 == mark:
	response = "true"
elif button2 == mark and button4 == mark and button6 == mark:
	response = "true"
